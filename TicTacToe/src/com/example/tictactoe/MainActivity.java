package com.example.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button btn;
	int cpu_turn = 0, turn = 1, dir, ind;
	int mat[][] = { {2, 2, 2},
					{2, 2, 2},
					{2, 2, 2} };
	
	void onAlert(int p) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		alertDialog.setTitle("Tic Tac Toe");
		System.out.println("p="+p);
		if(p==1){
			alertDialog.setMessage("CPU WON!!");
		}
		else{
			alertDialog.setMessage("Draw!!!");
		}
		alertDialog.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Add your code for the button here.
				finish();
				startActivity(getIntent());
			}
		});
		/*alertDialog.show();*/
		alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
				dialog.cancel();
			}
		});
		alertDialog.show();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	int game()
	{
		int pro1, pro2, i;
		pro1 = mat[0][0]*mat[1][1]*mat[2][2];
		pro2 = mat[0][2]*mat[1][1]*mat[2][0];
	    if(pro1 == 27 || pro1 == 64)
			return pro1;
		else if(pro2 == 27 || pro2 == 64)
			return pro2;
	    for(i=0;i<3;i++)
		{
			pro1 = mat[i][0]*mat[i][1]*mat[i][2];
			pro2 = mat[0][i]*mat[1][i]*mat[2][i];
			if(pro1 == 27 || pro1 == 64)
			    return pro1;
			else if(pro2 == 27 || pro2 == 64)
			    return pro2;
		}
	    
		return 0;
	}
	
	int posswin()
	{
		int pro1, pro2, ans=8, i;
		for(i=0;i<3;i++)
		{
			pro1 = mat[i][0]*mat[i][1]*mat[i][2];
			if(pro1 == 24 || pro1 == 36 || pro1 == 48)
			    pro1 = 1;
			pro2 = mat[0][i]*mat[1][i]*mat[2][i];
			if(pro2 == 24 || pro2 == 36 || pro2 == 48)
			    pro2 = 1;
			if(pro1 > ans || pro2 > ans)
			{
				if(pro1 >= pro2)
				{
			    	ans = pro1;
			    	ind = i;
			    	dir = 1;
				}
				else
				{
			    	ans = pro2;
			    	ind = i;
			    	dir = 2;
				}
			}
		}
		pro1 = mat[0][0]*mat[1][1]*mat[2][2];
		if(pro1 == 24 || pro1 == 36 || pro1 == 48)
			    pro1 = 1;
		pro2 = mat[0][2]*mat[1][1]*mat[2][0];
		if(pro2 == 24 || pro2 == 36 || pro2 == 48)
			    pro2 = 1;
		if(pro1 > ans || pro2 > ans)
		{
			if(pro1 > pro2)
			{
		    	ans = pro1;
		    	ind = 0;
		    	dir = 3;
			}
			else
			{
		    	ans = pro2;
		    	ind = 0;
		    	dir = 4;
			}
		}
		return ans;
	}
	
	int cpu(int t) {
		System.out.println("t = "+t);
		int a  = 0, i;
		if(t == 4 && mat[1][1] == 3) {
			if(mat[2][2] == 3)
			    return 7;
		}
		if(t == 2) {
			if(mat[1][1] == 2)
			    return 5;
			else if(mat[0][0] == 2)
			 	return 1;
		}
		else {
			a = posswin();
			System.out.println("a = "+a);
			if(a == 27 || a == 64)
				return a;
			else {
				if(dir == 1) {
					for(i=0;i<3;i++)
						if(mat[ind][i] == 2)
							return ind*3+i+1;
				}
				else if(dir == 2) {
					for(i=0;i<3;i++)
						if(mat[i][ind] == 2)
							return i*3+ind+1;
				}
				else if(dir == 3) {
					for(i=0;i<3;i++)
						if(mat[i][i] == 2)
							return i*3+i+1;
				}
				else if(dir == 4) {
					for(i=0;i<3;i++)
						if(mat[i][2-i] == 2)
							return i*3+(2-i)+1;
				}
			}
		}
		return a;		
	}
	
	void call(int x) {
		switch(x){
		case 1:
			btn = (Button)findViewById(R.id.button1);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 2:
			btn = (Button)findViewById(R.id.button2);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 3:
			btn = (Button)findViewById(R.id.button3);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 4:
			btn = (Button)findViewById(R.id.button4);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 5:
			btn = (Button)findViewById(R.id.button5);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 6:
			btn = (Button)findViewById(R.id.button6);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 7:
			btn = (Button)findViewById(R.id.button7);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 8:
			btn = (Button)findViewById(R.id.button8);
			cpu_turn = 1;
			btn.performClick();
			break;
		case 9:
			btn = (Button)findViewById(R.id.button9);
			cpu_turn = 1;
			btn.performClick();
			break;
		}
	}
	
	public void button_click1(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button1);
		if(cpu_turn == 1) {
			if(mat[0][0] == 2) {
				mat[0][0] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[0][0] == 2) {
				mat[0][0] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}
		
	}

	public void button_click2(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button2);
		if(cpu_turn == 1) {
			if(mat[0][1] == 2) {
				mat[0][1] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[0][1] == 2) {
				mat[0][1] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}
	}
	
	public void button_click3(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button3);
		if(cpu_turn == 1) {
			if(mat[0][2] == 2) {
				mat[0][2] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[0][2] == 2) {
				mat[0][2] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
	
	public void button_click4(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button4);
		if(cpu_turn == 1) {
			if(mat[1][0] == 2) {
				mat[1][0] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[1][0] == 2) {
				mat[1][0] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}
	}
		
	public void button_click5(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button5);
		if(cpu_turn == 1) {
			if(mat[1][1] == 2) {
				mat[1][1] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[1][1] == 2) {
				mat[1][1] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
	public void button_click6(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button6);
		if(cpu_turn == 1) {
			if(mat[1][2] == 2) {
				mat[1][2] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[1][2] == 2) {
				mat[1][2] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
	public void button_click7(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button7);
		if(cpu_turn == 1) {
			if(mat[2][0] == 2) {
				mat[2][0] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[2][0] == 2) {
				mat[2][0] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
	public void button_click8(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button8);
		if(cpu_turn == 1) {
			if(mat[2][1] == 2) {
				mat[2][1] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[2][1] == 2) {
				mat[2][1] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
	public void button_click9(View view) {
		turn++;
		System.out.println("t = "+turn);
		btn = (Button)findViewById(R.id.button9);
		if(cpu_turn == 1) {
			if(mat[2][2] == 2) {
				mat[2][2] = 4;
			}
			btn.setText("0");
			cpu_turn = 0;
			btn.setClickable(false);
		}
		else {
			if(mat[2][2] == 2) {
				mat[2][2] = 3;
			}
			btn.setText("X");
			btn.setClickable(false);
			int x = cpu(turn);
			call(x);
		}
		int g = game();
		System.out.println("g = "+g);
		if(g == 64)
		{
			onAlert(1);
			return;
		}
		else if(turn == 9)
		{
			onAlert(0);
			return;
		}

	}
}
