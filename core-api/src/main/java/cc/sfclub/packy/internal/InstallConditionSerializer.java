package cc.sfclub.packy.internal;

import cc.sfclub.packy.api.data.installer.InstallCondition;
import com.google.gson.*;

import java.lang.reflect.Type;

public class InstallConditionSerializer implements JsonDeserializer<InstallCondition>, JsonSerializer<InstallCondition> {
    @Override
    public InstallCondition deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (!json.isJsonPrimitive()) throw new JsonParseException("Not a json primitive.");
        String expr = json.toString();
        if (!expr.contains(" ")) {
            throw new JsonParseException("Invalid condition expression: " + expr);
        }
        int i = expr.indexOf(" ");
        String obj = expr.substring(0, i);
        String cond = expr.substring(i, expr.length() - 1);
        return new InstallCondition(obj, cond);
    }

    @Override
    public JsonElement serialize(InstallCondition src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getEnv() + " " + src.getCondition());
    }
}
