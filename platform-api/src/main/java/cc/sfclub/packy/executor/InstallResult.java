package cc.sfclub.packy.executor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class InstallResult {
    private String message;
    private boolean succeed;
}
