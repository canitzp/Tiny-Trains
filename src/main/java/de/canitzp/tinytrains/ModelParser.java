package de.canitzp.tinytrains;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ModelParser {
    
    public static <T extends AdvancedMinecartEntity<T>> SegmentedModel<T> fromBlockbenchModel(String modelLocation){
        InputStream is = ModelParser.class.getResourceAsStream(modelLocation);
        if(is != null){
            try(InputStreamReader isr = new InputStreamReader(is)){
                JsonElement root = new JsonParser().parse(isr);
                if(root.isJsonObject()){
                    if(root.getAsJsonObject().has("elements") && root.getAsJsonObject().get("elements").isJsonArray()){
                        ModelRenderer renderer = new ModelRenderer(256, 256, )
                        for(JsonElement element : root.getAsJsonObject().get("elements").getAsJsonArray()){
                        
                        }
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
            TinyTrains.LOGGER.error("Can't find '" + modelLocation + "'");
            return null;
        }
    }
    
}
