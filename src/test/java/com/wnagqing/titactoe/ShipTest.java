package com.wnagqing.titactoe;

import org.junit.Test;

public class ShipTest {

    // ship.location实例等于实例之前准备的locaiton
    @Test
    public void whenInstantiatedThenLocationIsSet() {

    }

    // ship.forward调用是否调用了location.forward方法
    @Test
    public void whenMoveForwardThenForward() {

    }

    // ship.backward调用是否调用了location.backward方法
    @Test
    public void whenBackforwardThenBackward() {

    }

    // ship.trunLeft 调用返回值是否等于location.trunLeft
    @Test
    public void whenTurnLeftThenLeft() {

    }

    // ship.trunRight 调用返回值是否等于location.trunRight
    @Test
    public void whenTurnRightThenRight() {

    }

    // 当ship.receiveCommand 调用，并且参数为‘f'时,产生的结果应该和location.forward() 调用结果一致
    @Test
    public void whenReceiveCommandsFThenForward() {

    }

    // 当ship.receiveCommand调用，并且参数为'b'是，产生的结果应该和location.forward()调用结果一致
    @Test
    public void whenReceiveCommandsBThenForward() {

    }

    // 当ship.receiveCommand调用，并且参数为'l"时，产生的结果应该和loction.turnLeft()调用结果一致
    @Test
    public void whenReceiveCommandsLThenTurnLeft() {

    }


    // 当ship.receiveCommand调用，并且参数为'r’时，产生的结果应该和locaiton.turnRight()调用结果一致
    @Test
    public void whenReceiveCommandsRThenTurnRight() {

    }

    // 当ship.receiveCommand调用，并且参数都是方法所有指令项，那么方法返回结果等于分别调用各个指令对应方法结果
    @Test
    public void whenReceiveCommandThenAllAreExecuted() {

    }

    // 当ship.planet 调用结果，应该和当初设置ship.planet值一致
    @Test
    public void whenInstantiatedThenPlanetIsStored() {

    }


    // 假定有Direction.EAST 并且x等于max.x 当调用receiveCommands ,并且参数为'f' ，那么调用结果等于1
    @Test
    public void givenDirectionEAndXEqualsMaxXWhenReceiveCommandsFThen1() {

    }

    // 假定Direction.EAST,并且x等于1,当调用receiveCommands，并且参数为‘b'后，那么调用结果应该等于max.x
    @Test
    public void givenDirectionEAndXEquals1WhenReceiveCommandsBThenMaxX() {

    }

    // 当receiveCommands被调用后，船因障碍物暂停移动
    @Test
    public void whenReceiveCommandsThenStopOnObstacle() {

    }

    // 当receiveCommands被调用之后，返回结果0代表ok，x代表被阻碍
    @Test
    public void whenReceiveCommandsThenOForOkAndXForObstracle() {

    }
}
