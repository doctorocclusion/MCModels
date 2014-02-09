package zap.mcmodel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Vertex
{
	public float[] position = new float[3];
	public short[] texcoord = new short[2];
	public float[] color = null;
	
	@SuppressWarnings("unchecked")
	public void write(JSONObject obj)
	{
		if (this.position != null)
		{
			JSONArray list = new JSONArray();
			
			for (float f : this.position)
			{
				list.add(f);
			}
			
			obj.put("position", list);
		}
		if (this.texcoord != null)
		{
			JSONArray list = new JSONArray();
			
			for (short s : this.texcoord)
			{
				list.add(s);
			}
			
			obj.put("texcoord", list);
		}
		if (this.color != null)
		{
			JSONArray list = new JSONArray();
			
			for (float f : this.color)
			{
				list.add(f);
			}
			
			obj.put("color", list);
		}
	}
}
