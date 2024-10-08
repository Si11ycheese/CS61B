package byog.Core;

class Position extends Coordinate {

    Position(int x, int y) {
        super(x, y);
    }

    Position() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        // 如果为同一对象的不同引用,则相同
        if (this == obj) {
            return true;
        }
        // 如果传入的对象为空,则返回false
        if (obj == null) {
            return false;
        }

        // 如果两者属于不同的类型,不能相等
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 类型相同, 比较内容是否相同
        Position other = (Position) obj;

        return other.x == this.x && other.y == this.y;
    }

    Position up() {
        return new Position(x, y + 1);
    }
    Position down() {
        return new Position(x, y - 1);
    }
    Position right() {
        return new Position(x + 1, y);
    }
    Position left() {
        return new Position(x - 1, y);
    }
}