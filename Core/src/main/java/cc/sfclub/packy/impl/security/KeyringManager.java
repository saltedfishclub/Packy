package cc.sfclub.packy.impl.security;

import cc.sfclub.packy.OperationSession;
import cc.sfclub.packy.util.Hash;
import lombok.SneakyThrows;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.BouncyGPG;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.callbacks.KeyringConfigCallbacks;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.keyrings.InMemoryKeyring;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.keyrings.KeyringConfigs;
import org.bouncycastle.openpgp.PGPException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

/**
 * **注意：** 该类并不属于暴露出去的 Packy API 的一部分，任何变动都可能在没有通知的情况下添加
 */
public class KeyringManager {
    public static final KeyringManager INSTANCE = new KeyringManager();
    private static InMemoryKeyring keyring = null;

    static {
        BouncyGPG.registerProvider();
        try {
            keyring = KeyringConfigs.forGpgExportedKeys(KeyringConfigCallbacks.withUnprotectedKeys());
        } catch (IOException | PGPException e) {
            e.printStackTrace();
            System.err.println("Could not initialize KeyringManager, Verifier will always return false.");
        }
    }

    private KeyringManager() {
    }

    @SneakyThrows
    public void addPublicKey(@NotNull String pubkey) {
        Objects.requireNonNull(keyring);
        keyring.addPublicKey(pubkey.getBytes(StandardCharsets.US_ASCII));
    }

    public boolean verify(OperationSession session) {
        if (keyring == null) {
            System.err.println("Could not initialize KeyringManager, Verifier will always return false.");
            return false;
        }
        try (InputStream is = BouncyGPG.decryptAndVerifyStream().withConfig(keyring)
                .andRequireSignatureFromAllKeys(session.getInstallingPackage().getGpgAssignee())
                .fromEncryptedInputStream(Files.newInputStream(session.getInstallingPackage().getGpgSignLoc().toPath(), StandardOpenOption.READ));) {
            byte[] buffer = new byte[4096];
            int n;
            while ((n = is.read(buffer)) != -1) {
            } //todo
            String str = new String(buffer);
            String[] s2 = str.split("\n");
            if (s2.length != 2) {
                // wrong format
                return false;
            }
            if (s2[0].equals(session.getInstallingPackage().getFullNameWithVersion()) && s2[1].equals(Hash.toHex(Hash.SHA256.checksum(session.getInstallingPackage().getCacheLoc())))) {
                return true;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("Failed to verify " + session.getInstallingPackage().getFullName());
        }
        return false;
    }
}
