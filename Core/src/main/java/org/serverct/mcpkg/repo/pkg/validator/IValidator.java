package org.serverct.mcpkg.repo.pkg.validator;

import org.jetbrains.annotations.ApiStatus;

import java.io.File;

@ApiStatus.AvailableSince("0.1.0")
public interface IValidator {
    boolean isSigned(File fileShouldBeGPGSigned);
}
