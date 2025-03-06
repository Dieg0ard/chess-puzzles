package com.chess.backend.service;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveException;
import com.github.bhlangonijr.chesslib.move.MoveList;
import com.github.bhlangonijr.chesslib.Square;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChessService {

    private Board board;

    public ChessService() {
        this.board = new Board();
    }

    // Cargar posición FEN
    public void setFen(String fen) {
        board.loadFromFen(fen);
    }

    // Obtener el FEN actual
    public String getFen() {
        return board.getFen();
    }

    // Hacer un movimiento y devolver el nuevo FEN
    public String makeMove(String from, String to) {
        List<Move> legalMoves = board.legalMoves();

        Move move = new Move(Square.valueOf(from), Square.valueOf(to));
        if (legalMoves.contains(move)) {
            board.doMove(move);
            return board.getFen();
        }

        return "Movimiento inválido";

    }

    // Verificar si la posición es mate o tablas
    public boolean isGameOver() {
        return board.isMated() || board.isDraw();
    }
}
