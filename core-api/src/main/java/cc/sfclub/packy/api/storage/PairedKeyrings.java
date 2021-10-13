package cc.sfclub.packy.api.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@AllArgsConstructor
@Getter
public class PairedKeyrings {
    private final File secKeyRing;
    private final File pubKeyRing;
}
