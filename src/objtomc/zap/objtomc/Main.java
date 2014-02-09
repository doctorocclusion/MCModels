package zap.objtomc;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import zap.mcmodel.Face;
import zap.mcmodel.JSONModel;
import zap.mcmodel.Vertex;
import zap.mcmodel.io.ModelWriter;

public class Main
{
	public static void main(String[] args)
	{
		JSONModel model = new JSONModel();

		model.name = "test";
		
		model.faces = new ArrayList<Face>();

		{
			Face face = new Face();
			face.tint = false;
			face.textureFacing = Face.TxtDir.UP;
			face.shade = 1.0F;
			
			{
				Vertex v = new Vertex();
				v.position = new float[] {0.0F, 1.0F, 0.0F};
				v.texcoord = new short[] {0, 0};
				face.vertices[0] = v;
			}
			
			{
				Vertex v = new Vertex();
				v.position = new float[] {1.0F, 1.0F, 0.0F};
				v.texcoord = new short[] {16, 0};
				face.vertices[1] = v;
			}
			
			{
				Vertex v = new Vertex();
				v.position = new float[] {1.0F, 1.0F, 1.0F};
				v.texcoord = new short[] {16, 16};
				face.vertices[2] = v;
			}
			
			{
				Vertex v = new Vertex();
				v.position = new float[] {0.0F, 1.0F, 1.0F};
				v.texcoord = new short[] {0, 16};
				face.vertices[3] = v;
			}
			
			model.faces.add(face);
		}
		
		JSONObject obj = new JSONObject();
		
		ModelWriter write = new ModelWriter(obj);
		write.write(model);
		
		System.out.println(obj);
	}
}
