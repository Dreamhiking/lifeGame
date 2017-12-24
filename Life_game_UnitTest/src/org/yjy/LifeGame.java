package org.yjy;

public class LifeGame {
	//设置棋盘的大小以及各种状态
	int MAXCOL=10, MAXROW=10,live,dead=1;
	int[][] LifeMap=new int[MAXROW][MAXCOL];
	int live_number=30;
	int col,row;
	
	
	public void init(){
		//先初始化棋盘,先默认判断细胞为活
		for(int i=0;i<MAXROW;i++)
			for(int j=0;j<MAXCOL;j++)
				LifeMap[i][j]=dead;
		
		//模拟存活的细胞30个
		for(int i=0;i<live_number;){
			row=(int) (Math.random()*MAXROW);
			col=(int) (Math.random()*MAXCOL);
			//将随机生成的细胞位置变成活
			if(0<=row&&row<MAXROW&&0<=col&&col<=MAXCOL){
				LifeMap[row][col]=live;
				i++;
			}			
		}		
	}
	
	public int checkNeign(int row,int col){
		//计算周围的活的细胞数目		
		int count=0;
		for(int i=row-1;i<row+1;i++){
			for(int j=col-1;j<col+1;j++){
				//如果是周围的边，不在范围内，就跳过
				if(i<0||j<0||i>=MAXROW||j>=MAXCOL)
					continue;
				
				if(LifeMap[i][j]==live)
					count++;
			}
		}
		if(LifeMap[row][col]==live)
			count--;
				
		return count;
	}
	
	public void showAll(){
		for(int i=0;i<MAXROW;i++){
			System.out .println();
			for(int j=0;j<MAXCOL;j++){
				if(LifeMap[i][j]==dead)
					System.out .print("-");
				else
					System.out .print("*");				
			}
		}
	}
	
	public void calucalteNext(){
		for(int i=0;i<MAXROW;i++){
			for(int j=0;j<MAXCOL;j++){
				int caseNo=checkNeign(i,j);
				//当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态
				if(caseNo==3){
					LifeMap[i][j]=live;
				}else if(caseNo==2){
					LifeMap[i][j]=LifeMap[i][j];
				}			
			}
		}
	}
	
	
	public static void main(String[] args){
		LifeGame game=new LifeGame();
		game.init();
		for(int i=0;i<3;i++){
			System.out .println("This is NO:"+i);			
			game.calucalteNext();
			game.showAll();
			System.out .println("\n\n");	
		}
	
	}
	
/*
 * 每个细胞有两种状态-存活或死亡，每个细胞与以自身为中心的周围八格细胞产生互动。（如图，黑色为存活，白色为死亡） 
当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时， 该细胞变成死亡状态。（模拟生命数量稀少）

当前细胞为存活状态时，当周围有2个或3个存活细胞时， 该细胞保持原样。

当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）

当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。 （模拟繁殖） 
可以把最初的细胞结构定义为种子，当所有在种子中的细胞同时被以上规则处理后, 可以得到第一代细胞图。按规则继续处理当前的细胞图，可以得到下一代的细胞图，周而复始。
 */
	

}
