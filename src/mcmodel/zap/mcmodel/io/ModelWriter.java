package zap.mcmodel.io;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import zap.mcmodel.Face;
import zap.mcmodel.JSONModel;

public class ModelWriter
{
	public JSONObject object;
	
	public ModelWriter(JSONObject object)
	{
		this.object = object;
	}
	
	@SuppressWarnings("unchecked")
	public void write(JSONModel model)
	{
		this.object.put("__comment", "Fair warning, this format is highly likely to change in the future!");
		this.object.put("__writer", "Produced by eekysam's JSON Minecraft Model API");
		this.object.put("__version", "Format specified by Minecraft snapshot 14w06b");
		
		this.object.put("name", model.name);
		
		JSONArray list = new JSONArray();
		
		for (Face f : model.faces)
		{
			JSONObject fo = new JSONObject();
			f.write(fo);
			list.add(fo);
		}
		
		this.object.put("faces", list);
	}
}
