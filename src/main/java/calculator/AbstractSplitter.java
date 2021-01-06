package calculator;

import java.util.List;

// 유저 인풋 클래스 받아서 배열반환해주는 역할
public interface AbstractSplitter {
    List<Integer> split(Input input);
}
