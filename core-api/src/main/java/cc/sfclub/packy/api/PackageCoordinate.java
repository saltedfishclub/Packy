package cc.sfclub.packy.api;

import com.github.zafarkhaja.semver.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor
@ApiStatus.AvailableSince("0.2.0")
@Getter
public final class PackageCoordinate {
    private String repo;
    private String name;
    @Nullable
    private Version version;

    /**
     * parser.
     * @param str repo/package[:version]
     * @return parsed
     */
    @Nullable
    public static PackageCoordinate fromString(String str){
        String[] s=str.split("/");
        if(s.length!=2){
            return null;
        }
        String[] s2=s[1].split(":");
        if(s2.length==0){
            return new PackageCoordinate(s[0],s[1],null);
        }
        return new PackageCoordinate(s[0],s2[0],Version.valueOf(s2[1]));
    }
    @Override
    public String toString(){
        return repo+"/"+name+(version!=null?":"+ version :"");
    }
}
