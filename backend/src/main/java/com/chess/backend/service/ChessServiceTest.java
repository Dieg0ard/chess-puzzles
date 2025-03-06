package com.chess.backend.service;

public class ChessServiceTest {
    public static void main(String[] args) {
        ChessService chessService = new ChessService();

        testSetAndGetFen(chessService);
        testMakeValidMove(chessService);
        testMakeInvalidMove(chessService);
        testGameOver(chessService);
    }

    private static void testSetAndGetFen(ChessService chessService) {
        String startFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        chessService.setFen(startFen);
        if (startFen.equals(chessService.getFen())) {
            System.out.println("testSetAndGetFen PASSED");
        } else {
            System.out.println("testSetAndGetFen FAILED");
        }
    }

    private static void testMakeValidMove(ChessService chessService) {
        chessService.setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        String newFen = chessService.makeMove("E2", "E4");
        if (!"Movimiento inválido".equals(newFen)) {
            System.out.println("testMakeValidMove PASSED");
        } else {
            System.out.println("testMakeValidMove FAILED");
        }
    }

    private static void testMakeInvalidMove(ChessService chessService) {
        chessService.setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        String result = chessService.makeMove("E2", "E5"); // Movimiento inválido
        if ("Movimiento inválido".equals(result)) {
            System.out.println("testMakeInvalidMove PASSED");
        } else {
            System.out.println("testMakeInvalidMove FAILED");
        }
    }

    private static void testGameOver(ChessService chessService) {
        chessService.setFen("rnb1kbnr/pppp1ppp/8/8/8/8/PPPP1PPP/RNBQKBNR w KQkq - 0 1");
        if (!chessService.isGameOver()) {
            System.out.println("testGameOver PASSED");
        } else {
            System.out.println("testGameOver FAILED");
        }
    }
}