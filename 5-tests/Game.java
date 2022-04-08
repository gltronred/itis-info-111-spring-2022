// Ход неправильный
class WrongMove extends Exception {}
// Ход вне поля
class MoveOutOfBounds extends WrongMove {}
// Ход на занятое поле
class FieldIsOccupied extends WrongMove {}

// Крестик и нолик
enum Value {
    X, O
}

// Класс для игры в крестики-нолики
// - начинает крестик
public class Game {
    // конструктор задаёт размеры поля и
    // длину для выигрыша
    public Game(int size, int winLength) {}
    // геттеры для размера поля и
    // длины выигрышной линии
    public int getFieldSize() { return -1; }
    public int getWinLength() { return -1; }
    // метод, чей ход сейчас
    public Value getPlayer() { return Value.X; }
    // возвращает значение клетки (крестик или нолик)
    // или null, если клетка пустая
    public Value getField(int x, int y) {
        return null;
    }
    // делает ход и выбрасывает исключение, если
    // ход неправильный
    // если ход был правильный, очередность хода
    // переходит к следующему игроку
    public void move(int x, int y)
        throws WrongMove {}
    // метод, возвращает, есть ли выигравший и
    // кто это (крестик или нолик; если никто -
    // то null)
    public Value winner() { return null; }
}
