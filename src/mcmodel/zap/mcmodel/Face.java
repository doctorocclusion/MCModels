package zap.mcmodel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Face
{
	public static enum CullFace
	{
		UP("up"),
		DOWN("down"),
		NORTH("north"),
		SOUTH("south"),
		EAST("east"),
		WEST("west"),
		NONE("none");
		
		public String id;
		
		CullFace(String id)
		{
			this.id = id;
		}
	}
	
	public static enum TxtDir
	{
		UP("up"),
		DOWN("down"),
		NORTH("north"),
		SOUTH("south"),
		EAST("east"),
		WEST("west");
		
		public String id;
		
		TxtDir(String id)
		{
			this.id = id;
		}
	}
	
	public CullFace cullFacing = null;
	public Float shade = null;
	public Boolean tint = null;
	public TxtDir textureFacing = null;
	public Boolean overlay = null;
	public Vertex[] vertices = new Vertex[4];
	
	@SuppressWarnings("unchecked")
	public void write(JSONObject obj)
	{
		if (this.cullFacing != null)
		{
			obj.put("cullFacing", this.cullFacing.id);
		}
		if (this.shade != null)
		{
			obj.put("shade", this.shade);
		}
		if (this.tint != null)
		{
			obj.put("tint", this.tint);
		}
		if (this.textureFacing != null)
		{
			obj.put("textureFacing", this.textureFacing.id);
		}
		if (this.overlay != null)
		{
			obj.put("overlay", this.overlay);
		}
		
		if (this.vertices != null)
		{
			JSONArray list = new JSONArray();
			
			for (Vertex v : this.vertices)
			{
				JSONObject vo = new JSONObject();
				v.write(vo);
				list.add(vo);
			}
			
			obj.put("vertices", list);
		}
	}
}
