package Program;

import java.util.Random;

import OutPut.DrawPanel;
import Value.value;

public class Main {

	//*****�ŧi�ܼ�*****//
	public static double[] x;//X�b��
	public static double[] y;//Y�b��
	public static int total;//�`��ƶq
	public static int time;//�N��
	public static int outputlayer;//��X�h
	public static double eps;//�b�|
	public static double a;//�Y�p�]��
	public static double n;//�ǲ߳t�v
	
	public static double[] oplx;
	public static double[] oply;
	static value[] opl;
	
	public static void main()
	{
		Random rd = new Random();
		//Set<Integer> checkpoint = new HashSet<>();
		//*****��l�ƿ�X�h*****//
		oplx = new double[outputlayer*outputlayer];
		oply = new double[outputlayer*outputlayer];
		opl = new value[outputlayer*outputlayer];
		for(int i=0;i<oplx.length;i++)//��lXY�H�u��
		{
			int c = rd.nextInt(total);
			/*while(checkpoint.add(c) == false)
			{
				c = rd.nextInt(total);
			}*/
			oplx[i] = x[c];
			oply[i] = y[c];
			
		}
		int count =0;
		for(int x=0;x<outputlayer;x++)//�����ݼ�
		{
			for(int y=0;y<outputlayer;y++)
			{
				opl[count] = new value(); 
				opl[count].x = x;
				opl[count].y = y;
				count++;
			}
		}
		
		for(int t=0;t<time;t++)
		{
			//*****�M���u�q���g��*****//
			for(int xy=0;xy<total;xy++)
			{
				double[] dis = new double[oplx.length];
				for(int o=0;o<oplx.length;o++)
				{
					dis[o] = XYdistance(xy,o);
				}
				int best = minvalue(dis);//�u�q���g��
				for(int o=0;o<oplx.length;o++)
				{
					double K = colse(TPdistance(best,o));
					double w1 = n*(x[xy]-oplx[o])*K;
					double w2 = n*(y[xy]-oply[o])*K;
					oplx[o] += w1;
					oply[o] += w2;
				}
			}
			
			//*****�Y�p�b�|*****//
			eps = a*eps;
			
			//*****�Y�p�ǲ߳t�v*****//
			n = a*n;
			
			//*****��X*****//
			outputline();
		}
		//outputline();
	}
	//*****��X*****//
	public static void outputline()
	{
		DrawPanel.drawpanel();
		for(int i=0;i<outputlayer*outputlayer;i++)
		{
			for(int j=0;j<outputlayer*outputlayer;j++)
			{
				if(TPdistance(i,j) == 1)
				{
					
					DrawPanel.drawline(i, j);
				}
			}
		}
	}
	
	//*****�F����*****//
	public static double colse(double dis)
	{
		double tmp = 0;
		tmp = Math.exp((-1)*Math.pow(dis/eps, 2));
		return tmp;
	}
	
	//*****XY�H���Z������*****//
	public static double XYdistance(int pointA, int pointB)
	{
		double re=0;
		re = Math.sqrt(Math.pow(x[pointA]-oplx[pointB], 2)+Math.pow(y[pointA]-oply[pointB], 2));
		return re;
	}
	
	//*****�ݼ��Z������*****//
	public static double TPdistance(int pointA, int pointB)
	{
		double re=0;
		re = Math.sqrt(Math.pow(opl[pointA].x-opl[pointB].x, 2)+Math.pow(opl[pointA].y-opl[pointB].y, 2));
		return re;
	}
	
	//*****��X�̤p��*****//
	public static int minvalue(double[] dis)
	{
		int tmp = 0;
		for(int i=0;i<dis.length;i++)
		{
			if(dis[i]<dis[tmp])
			{
				tmp = i;
			}
		}
		return tmp;
	}
}
