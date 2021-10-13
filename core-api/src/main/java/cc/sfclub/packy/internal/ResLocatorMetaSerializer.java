package cc.sfclub.packy.internal;

import cc.sfclub.packy.api.repo.pkg.ver.ResLocatorMeta;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ResLocatorMetaSerializer implements JsonSerializer<ResLocatorMeta>, JsonDeserializer<ResLocatorMeta> {
    @Override
    public ResLocatorMeta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonPrimitive()) throw new JsonParseException("Not a json primitive");
        var jo = json.toString();
        // http
        if (jo.startsWith("@http ")) {
            return new ResLocatorMeta(ResLocatorMeta.Type.HTTP, jo.substring(jo.indexOf("@http ", jo.length() - 1)));
        }
        return new ResLocatorMeta(ResLocatorMeta.Type.PACKAGE_REF, jo);

    }

    @Override
    public JsonElement serialize(ResLocatorMeta src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getType() == ResLocatorMeta.Type.HTTP
                ? "@http " + src.getData()
                : src.getData());
    }
}
