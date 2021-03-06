
import  java.awt.*;

public class MyOval extends MyDrawing
{	
	//MyOvalのコンストラクタの設定
	public MyOval(int x,int y,int w,int h,
			int r,Color lc,Color fc, int lw){
			super(x,y,w,h,r,lc,fc,lw);
			setType('O');
	}
	//座標、幅、高さ,色を指定する
	public MyOval(int x,int y,int w,int h,Color lc,Color fc){
		this(x,y,w,h,30,lc ,fc,1);
	}
	//座標、幅、高さを指定する
	public MyOval(int x,int y,int w,int h){
		this(x,y,w,h,30,Color.black ,Color.blue,1);
	}
	//座標と色を指定する
	public MyOval(int x,int y, Color lc, Color fc){
		this(x,y,30,30,30,lc,fc,1);
	}
	//座標を指定する
	public MyOval(int x,int y){
		this(x,y,60,30,30,Color.black ,Color.blue,1);
	}
	//色を指定する
	public MyOval(Color lc,Color fc){
		this(30,30,30,30,30, lc , fc,1);
	}
	//何も指定しない
	public MyOval(){
		this(20,20,20,20,30,Color.black ,Color.blue,1);
	}

	public void draw(Graphics g){
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		//高さや横幅が負のときのための処理
		if ( w < 0 ) {
			x += w;
			w *= -1;
		}
		if ( h < 0 ) {
			y += h;
			h *= -1;
		}
		Graphics2D g2 = (Graphics2D) g;
		
		if(getShadow())
		{
			g2.setStroke(new BasicStroke(getLineWidth()));
			g2.setColor(Color.black);
			g2.fillOval(x+5,y+5,w,h);
			g2.setColor(Color.black);
			g2.drawOval(x+5,y+5,w,h);
		}
		if(getDashed()){
			g2.setStroke(new MyDashStroke(getLineWidth()));
		}else{
			g2.setStroke(new BasicStroke(getLineWidth()));
		}
		g2.setColor(getFillColor());
		g2.fillOval(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawOval(x, y, w, h);
		super.draw(g);
	}
}