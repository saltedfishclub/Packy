package cc.sfclub.packy.impl.repo.pkg.validator;

import cc.sfclub.packy.impl.security.KeyringManager;
import cc.sfclub.packy.repo.pkg.validator.IValidator;
import cc.sfclub.packy.session.OperationSession;
import com.google.auto.service.AutoService;

@AutoService(IValidator.class)
public class GPGValidatorImpl implements IValidator {
    @Override
    public boolean verify(OperationSession packageInfo) {
        return KeyringManager.INSTANCE.verify(packageInfo);
    }
}
