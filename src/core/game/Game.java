package core.game;

import static core.board.PieceColor.BLACK;
import static core.board.PieceColor.WHITE;



import core.board.Board;
import core.player.Player;

/** ��������Ϸ
 *  @author Jianliang Xu
 */
public class Game {

    /** һ���µ���Ϸ��������board���� */
	public Game(Board board) {
        _board = board;
        _constBoard = _board.constantView();
    }
	/**
	 * ���black��white������board�Ͽ�ʼһ���µ���Ϸ
	 * @param board ����
	 * @param black �ֺ��ӵ�һ�����
	 * @param white �ְ��ӵ�һ�����
	 */
	public Game(Board board, Player black, Player white) {
		this(board);
		this.black = black;
		this.white = white;
		black.setColor(BLACK);
		white.setColor(WHITE);
		black.playGame(this);
		white.playGame(this);
	}

	/** ���ص�ǰ���̵�ֻ����ͼ */
    public Board board() {
        return _constBoard;
    }

    /** �ҵ����̺����̵�ֻ����ͼ */
    private Board _board, _constBoard;
    
    /**
     * ˫������Ĺ���
     * @return ������Ϸ�Ľ����Ҫô����ʤ��Ҫô����ʤ��Ҫôƽ��
     */
    public String process() {
    	Move currentMove = null;
    	_board.clear();
    	_board.draw();
    	int step = 0;
        while (true) {    
        	Move move = null;
        	if (_board.whoseMove() == BLACK) {
        		if (black.isManual()) System.out.print("black>");
        		move = black.findMove(currentMove);
        	} else {
        		if (white.isManual()) System.out.print("white>");
        		move = white.findMove(currentMove);
        	}
        	_board.makeMove(move);
        	_board.draw();
        	currentMove = move;
        	step++;
        	if(step>80) {
        		System.out.println("����80��,ƽ��");
        		return "tie";
        	}
        	if(_board.gameOver()) {
        		System.out.println(_board.whoseMove().opposite()+"ʤ��,��Ϸ����");
        		if(_board.whoseMove().opposite()==WHITE) {
        			return "whiteWin";
        		}else {
        			return "blackWin";
        		}
        	}
        }
       // _constBoard.draw();
    }
    
//    /**  recording the game into a file */
//    public void record(File gameRecord) {
//    	
//    	_board.record(gameRecord);
//    }
    /**
     * �ֺ��ӵ�һ�����
     */
    Player black = null;	
    /**
     * �ְ��ӵ�һ�����
     */
    Player white = null;    
}
