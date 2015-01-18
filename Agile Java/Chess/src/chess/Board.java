package chess;

import java.util.*;
import pieces.*;
import pieces.Piece.COLOR;
import util.StringUtil;

/**
 *
 * A board of pawns
 */
public class Board {

    static final int PIECES_PER_RANK = 8;
    static final int RANKS_PER_BOARD = 8;

    private int piecesCount;
    private final List<List<Piece>> table = new ArrayList<>(RANKS_PER_BOARD);

    Board() {
        addEmptyRanks();
    }

    Board(String inputBoard) {
        String processedInput = processInputBoard(inputBoard);

        String[] ranks = processedInput.split("\n");
        for (int i = ranks.length - 1; i >= 0; i--) {
            String rankString = ranks[i];
            List<Piece> rank = new ArrayList<>(PIECES_PER_RANK);
            for (char p : rankString.toCharArray())
                rank.add(Piece.createPieceByRepresentation(p));
            table.add(rank);
        }
    }

    static public int getRankFromPosition(String position) {
        for (char value : position.toCharArray())
            if (Character.isDigit(value))
                return Integer.parseInt("" + value) - 1;

        throw new InvalidPositionException();
    }

    static public int getFileFromPosition(String position) {
        for (char value : position.toCharArray())
            if (Character.isLetter(value))
                return charFileToInt(value);

        throw new InvalidPositionException();
    }

    static public String positionToString(int rank, int file) {
        String fileString = String.valueOf((char) ('a' + file));
        return fileString + String.valueOf(rank + 1);
    }

    public void initialize() {
        addEmptyRanks();
        addWhiteFigureRank();
        addWhitePawnsRank();
        addBlackPawnsRank();
        addBlackFigureRank();
    }

    int piecesCount() {
        return piecesCount;
    }

    String printRank(int index) {
        List<Piece> rank = table.get(index - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < PIECES_PER_RANK; i++)
            result.append(rank.get(i).getRepresentation());

        return result.toString();
    }

    String print() {
        StringBuilder result = new StringBuilder();
        for (int i = RANKS_PER_BOARD - 1; i >= 0; i--) {
            List<Piece> rank = table.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++)
                result.append(rank.get(j).getRepresentation());

            result.append(StringUtil.NEWLINE);
        }

        return result.toString();
    }

    void put(Piece piece, String position) {
        int rankNumber = getRankFromPosition(position);
        int fileNumber = getFileFromPosition(position);
        table.get(rankNumber).set(fileNumber, piece);
    }

    int countPieces(char representation) {
        int count = 0;
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            List<Piece> rank = table.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++)
                if (rank.get(j).getRepresentation() == representation)
                    count++;
        }
        return count;
    }

    Piece getPieceAt(String position) {
        int rankNumber = -1;
        int fileNumber = -1;
        for (char value : position.toCharArray()) {
            if (Character.isDigit(value))
                rankNumber = Integer.parseInt("" + value) - 1;
            else if (Character.isLetter(value)) {
                fileNumber = charFileToInt(value);
            }
        }
        return table.get(rankNumber).get(fileNumber);
    }

    Piece getPieceAt(int rank, int file) {
        return table.get(rank).get(file);
    }


    /*
     Privates
     */
    private void addEmptyRanks() {
        for (int i = 0; i < RANKS_PER_BOARD; i++)
            createEmptyRank();
    }

    private void createEmptyRank() {
        List<Piece> newRank = new ArrayList<>(PIECES_PER_RANK);
        for (int j = 0; j < PIECES_PER_RANK; j++)
            newRank.add(new NoPiece());
        table.add(newRank);
    }

    private void addWhitePawnsRank() {
        List<Piece> pawnRank = new ArrayList<>(PIECES_PER_RANK);
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            pawnRank.add(new Pawn(Piece.COLOR.WHITE));
            piecesCount++;
        }
        table.set(1, pawnRank);
    }

    private void addBlackPawnsRank() {
        List<Piece> pawnRank = new ArrayList<>(PIECES_PER_RANK);
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            pawnRank.add(new Pawn(Piece.COLOR.BLACK));
            piecesCount++;
        }
        table.set(RANKS_PER_BOARD - 2, pawnRank);
    }

    private void addWhiteFigureRank() {
        List<Piece> rank = createFigureRankOfColor(Piece.COLOR.WHITE);
        piecesCount += PIECES_PER_RANK;
        table.set(0, rank);
    }

    private List<Piece> createFigureRankOfColor(COLOR color) {
        List<Piece> rank = new ArrayList<>(PIECES_PER_RANK);
        rank.add(new Rook(color));
        rank.add(new Knight(color));
        rank.add(new Bishop(color));
        rank.add(new Queen(color));
        rank.add(new King(color));
        rank.add(new Bishop(color));
        rank.add(new Knight(color));
        rank.add(new Rook(color));
        return rank;
    }

    private void addBlackFigureRank() {
        List<Piece> rank = createFigureRankOfColor(COLOR.BLACK);
        piecesCount += PIECES_PER_RANK;
        table.set(RANKS_PER_BOARD - 1, rank);
    }

    static private int charFileToInt(char value) {
        if (value < 'a' || value > 'h')
            throw new InvalidPositionException();

        return value - 'a';
    }

    private boolean isInputBoardWithLabels(String inputBoard) {
        if (inputBoard.contains("abcdefgh")) {
            for (int i = 1; i <= 8; i++) {
                if (!inputBoard.contains(String.valueOf(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    private String processInputBoard(String inputBoard) {
        if (!isInputBoardWithLabels(inputBoard))
            return inputBoard;

        String result = reverseInputIfNeeded(inputBoard);
        result = removeFileLabels(result);
        result = removeRankLabels(result);

        return result;
    }

    private String removeFileLabels(String inputBoard) {
        return inputBoard.replace(StringUtil.appendNewLine("abcdefgh"), "");
    }

    private String reverseInputIfNeeded(String input) {
        String[] ranks = input.split(StringUtil.NEWLINE);

        if (ranks[0].charAt(ranks[0].length() - 1) == '8')
            return input;

        StringBuilder result = new StringBuilder();
        for (int i = ranks.length - 1; i >= 0; i--)
            result.append(StringUtil.appendNewLine(ranks[i]));

        return result.toString();
    }

    private String removeRankLabels(String input) {
        String[] ranks = input.split(StringUtil.NEWLINE);

        StringBuilder result = new StringBuilder();
        for (String rank : ranks)
            result.append(StringUtil.appendNewLine(
                    rank.substring(0, PIECES_PER_RANK)));

        return result.toString();
    }

    private static class InvalidPositionException extends RuntimeException {

        public InvalidPositionException() {
        }
    }

}
