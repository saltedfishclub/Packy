package cc.sfclub.packy.repo.pkg.validator;

import cc.sfclub.packy.OperationSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface IValidator {
    boolean verify(OperationSession packageInfo);
}
