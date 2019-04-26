package core.game;

import java.util.ArrayList;
import java.util.Iterator;

import core.player.Player;

public class GameEvent {
	/**
	 * �޲ι��캯����������������Ϸ
	 */
	public GameEvent() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ����Ϸ���������
	 * @param player ����Ϸ�����ӵ����
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	/**
	 * ��Ŵ˴���������Ϸ���������
	 */
	ArrayList<Player> players = new ArrayList<>();
	/**
	 * ���е�����������ģ����ÿ�����ĵ���Ϸ���
	 */
	ArrayList<GameResult> gameResults=new ArrayList<>();
	/**
	 * ���в����ߵı���(match)����
	 * @param gameNumbers ÿ��������match�����ļ���
	 */
	public void arrangeMatches(int gameNumbers) {
		
		
		int size = players.size();		
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				matches.add(new Match(gameNumbers, players.get(i), players.get(j)));
			}
		}
	}
	
	/**
	 * ��Ŵ˴���������Ϸ�����б���
	 */
	ArrayList<Match> matches = new ArrayList<>();
	
	/**
	 * �������ĵı������̣�����ӡ�������
	 */
	public void run() {
		Iterator<Match> itr = matches.iterator();
		while (itr.hasNext()) {
			Match match = itr.next();
			match.process();
			gameResults.add(match.getGameResult());
		}
		printResult(gameResults);
	}
	/**
	 * ��ӡ���յı������
	 * @param gameResults ��������
	 */
	public void printResult(ArrayList<GameResult> gameResults) {
		System.out.println("----------���Ľ��----------");
		for(int i=0;i<gameResults.size();i++) {
			GameResult gameResult = gameResults.get(i);
			System.out.println(gameResult.getBlackName()+"��"+gameResult.getWhiteName()+"������"+gameResult.getGameNumbers()+"�Σ�����:");
			System.out.println(gameResult.getBlackName()+"��ʤ������:"+gameResult.getBlackWin());
			System.out.println(gameResult.getWhiteName()+"��ʤ������:"+gameResult.getWhiteWin());
			System.out.println("ƽ�ִ���:"+gameResult.getTie());
			System.out.println("--------------------------");
		}
	}
	
	
}