package cc.sfclub.packy.executor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InstallResult {
    private String message;
    private boolean succeed;
}
