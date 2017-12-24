package org.yjy;

public class LifeGame {
	//�������̵Ĵ�С�Լ�����״̬
	int MAXCOL=10, MAXROW=10,live,dead=1;
	int[][] LifeMap=new int[MAXROW][MAXCOL];
	int live_number=30;
	int col,row;
	
	
	public void init(){
		//�ȳ�ʼ������,��Ĭ���ж�ϸ��Ϊ��
		for(int i=0;i<MAXROW;i++)
			for(int j=0;j<MAXCOL;j++)
				LifeMap[i][j]=dead;
		
		//ģ�����ϸ��30��
		for(int i=0;i<live_number;){
			row=(int) (Math.random()*MAXROW);
			col=(int) (Math.random()*MAXCOL);
			//��������ɵ�ϸ��λ�ñ�ɻ�
			if(0<=row&&row<MAXROW&&0<=col&&col<=MAXCOL){
				LifeMap[row][col]=live;
				i++;
			}			
		}		
	}
	
	public int checkNeign(int row,int col){
		//������Χ�Ļ��ϸ����Ŀ		
		int count=0;
		for(int i=row-1;i<row+1;i++){
			for(int j=col-1;j<col+1;j++){
				//�������Χ�ıߣ����ڷ�Χ�ڣ�������
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
				//��ǰϸ��Ϊ���״̬ʱ������Χ��3�����ϵĴ��ϸ��ʱ����ϸ���������״̬
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
 * ÿ��ϸ��������״̬-����������ÿ��ϸ����������Ϊ���ĵ���Χ�˸�ϸ����������������ͼ����ɫΪ����ɫΪ������ 
��ǰϸ��Ϊ���״̬ʱ������Χ����2����������2�������ϸ��ʱ�� ��ϸ���������״̬����ģ����������ϡ�٣�

��ǰϸ��Ϊ���״̬ʱ������Χ��2����3�����ϸ��ʱ�� ��ϸ������ԭ����

��ǰϸ��Ϊ���״̬ʱ������Χ��3�����ϵĴ��ϸ��ʱ����ϸ���������״̬����ģ�������������ࣩ

��ǰϸ��Ϊ����״̬ʱ������Χ��3�����ϸ��ʱ����ϸ����ɴ��״̬�� ��ģ�ֳⷱ�� 
���԰������ϸ���ṹ����Ϊ���ӣ��������������е�ϸ��ͬʱ�����Ϲ������, ���Եõ���һ��ϸ��ͼ���������������ǰ��ϸ��ͼ�����Եõ���һ����ϸ��ͼ���ܶ���ʼ��
 */
	

}
