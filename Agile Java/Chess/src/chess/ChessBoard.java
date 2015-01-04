package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pieces.Piece;
import util.StringUtil;

/**
 *
 * A board of pawns
 */
class ChessBoard {

    static private final int PIECES_PER_RANK = 8;
    static private final int RANKS_PER_BOARD = 8;

    private int piecesCount;
    private final List<List<Piece>> table = new ArrayList<>(RANKS_PER_BOARD);
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    ChessBoard() {
        addEmptyRanks();
    }

    ChessBoard(String inputBoard) {

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

    void add(Piece piece, String position) {
        int rankNumber = parseRankNumber(position);
        int fileNumber = parseFileNumber(position);
        table.get(rankNumber).set(fileNumber, piece);
    }

    int countPieces(char representation) {
        int count = 0;
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            List<Piece> rank = table.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++)
                if (rank.get(j).getRepresentation() == (representation))
                    count++;
        }
        return count;
    }

    char getPieceAt(String position) {
        int rankNumber = -1;
        int fileNumber = -1;
        for (char value : position.toCharArray()) {
            if (Character.isDigit(value))
                rankNumber = Integer.parseInt("" + value) - 1;
            else if (Character.isLetter(value)) {
                fileNumber = charFileToInt(value);
            }
        }
        return table.get(rankNumber).get(fileNumber).getRepresentation();
    }

    double countWhitesPoints() {
        double total = 0;
        setPointsForAllPieces();
        updatePieceColections();

        for (Piece piece : whitePieces)
            total += piece.getPoints();

        return total;
    }

    double countBlacksPoints() {
        double total = 0;
        setPointsForAllPieces();
        updatePieceColections();

        for (Piece piece : blackPieces)
            total += piece.getPoints();

        return total;
    }
    /*
     Privates
     */

    private void updatePieceColections() {
        whitePieces.clear();
        blackPieces.clear();

        for (int i = 0; i < RANKS_PER_BOARD; i++)
            for (int j = 0; j < PIECES_PER_RANK; j++) {
                Piece piece = table.get(i).get(j);
                if (piece.isWhite())
                    whitePieces.add(piece);
                else if (piece.isBlack())
                    blackPieces.add(piece);
            }
        Collections.sort(whitePieces);
        Collections.sort(blackPieces);
    }

    private void addEmptyRanks() {
        for (int i = 0; i < RANKS_PER_BOARD; i++)
            createEmptyRank();
    }

    private void createEmptyRank() {
        List<Piece> newRank = new ArrayList<>(PIECES_PER_RANK);
        for (int j = 0; j < PIECES_PER_RANK; j++)
            newRank.add(Piece.noPiece());
        table.add(newRank);
    }

    private void addWhitePawnsRank() {
        List<Piece> pawnRank = new ArrayList<>(PIECES_PER_RANK);
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            pawnRank.add(Piece.createWhite(Piece.Type.PAWN));
            piecesCount++;
        }
        table.set(1, pawnRank);
    }

    private void addBlackPawnsRank() {
        List<Piece> pawnRank = new ArrayList<>(PIECES_PER_RANK);
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            pawnRank.add(Piece.createBlack(Piece.Type.PAWN));
            piecesCount++;
        }
        table.set(RANKS_PER_BOARD - 2, pawnRank);
    }

    private void addWhiteFigureRank() {
        List<Piece> rank = createWhiteFigureRank();
        piecesCount += PIECES_PER_RANK;
        table.set(0, rank);
    }

    private List<Piece> createWhiteFigureRank() {
        List<Piece> rank = new ArrayList<>(PIECES_PER_RANK);
        rank.add(Piece.createWhite(Piece.Type.ROOK));
        rank.add(Piece.createWhite(Piece.Type.KNIGHT));
        rank.add(Piece.createWhite(Piece.Type.BISHOP));
        rank.add(Piece.createWhite(Piece.Type.QUEEN));
        rank.add(Piece.createWhite(Piece.Type.KING));
        rank.add(Piece.createWhite(Piece.Type.BISHOP));
        rank.add(Piece.createWhite(Piece.Type.KNIGHT));
        rank.add(Piece.createWhite(Piece.Type.ROOK));
        return rank;
    }

    private void addBlackFigureRank() {
        List<Piece> rank = createBlackFigureRank();
        piecesCount += PIECES_PER_RANK;
        table.set(RANKS_PER_BOARD - 1, rank);
    }

    private List<Piece> createBlackFigureRank() {
        List<Piece> rank = new ArrayList<>(PIECES_PER_RANK);
        rank.add(Piece.createBlack(Piece.Type.ROOK));
        rank.add(Piece.createBlack(Piece.Type.KNIGHT));
        rank.add(Piece.createBlack(Piece.Type.BISHOP));
        rank.add(Piece.createBlack(Piece.Type.QUEEN));
        rank.add(Piece.createBlack(Piece.Type.KING));
        rank.add(Piece.createBlack(Piece.Type.BISHOP));
        rank.add(Piece.createBlack(Piece.Type.KNIGHT));
        rank.add(Piece.createBlack(Piece.Type.ROOK));
        return rank;
    }

    private int charFileToInt(char value) {
        if (value < 'a' || value > 'h')
            throw new InvalidPositionException();

        return value - 'a';
    }

    private int parseRankNumber(String position) {
        for (char value : position.toCharArray())
            if (Character.isDigit(value))
                return Integer.parseInt("" + value) - 1;

        throw new InvalidPositionException();
    }

    private int parseFileNumber(String position) {
        for (char value : position.toCharArray())
            if (Character.isLetter(value))
                return charFileToInt(value);

        throw new InvalidPositionException();
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

    private void setPiecePoints(Piece piece) {
        switch (piece.getType()) {
            case QUEEN:
                piece.setPoints(9);
                break;
            case ROOK:
                piece.setPoints(5);
                break;
            case BISHOP:
                piece.setPoints(3);
                break;
            case KNIGHT:
                piece.setPoints(2.5);
                break;
        }
    }

    private void setPawnPoints(Piece piece, int file) {
        int pawnCount = 0;
        boolean isWhite = piece.isWhite();

        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            Piece p = table.get(i).get(file);
            if (p.getType() == Piece.Type.PAWN && p.isWhite() == isWhite)
                pawnCount++;
        }
        if (pawnCount > 1)
            piece.setPoints(0.5);
        else
            piece.setPoints(1);
    }

    private void setPointsForAllPieces() {
        for (int i = 0; i < RANKS_PER_BOARD; i++)
            for (int j = 0; j < PIECES_PER_RANK; j++) {
                Piece piece = table.get(i).get(j);
                if (piece.getType() != Piece.Type.NO_PIECE) {
                    if (piece.getType() == Piece.Type.PAWN)
                        setPawnPoints(piece, j);
                    else
                        setPiecePoints(piece);
                }
            }
    }

    private static class InvalidPositionException extends RuntimeException {

        public InvalidPositionException() {
        }
    }

}
