业务词义：
Model层:
Box:一个原子性方框，组成Block和Board的元素
Block:由多个（一般为4个）Box组成的图形
Board:Block运行区域,一个长方形面板（一般由24*12个Box组成）
Preview:下一个要出现的Block队列
Style:Block的各种状态样式
Direction:Block的方向
Row:从Board最上边算起，即最上边Row为0
Col:从Board最左边算起，即最左边Col为0
Location:对Row和Col的封装,相对于Board左上角的坐标

View层:
Canvas:用于作图的面板称为画板
Panel:用于容纳其它控件的面板
Frame:面板呈现的窗体
Button:按钮
其它对应Swing控件

规范要求:
所以程序的业务逻辑运作都必需在Model内,
View层只观察Model的变化和发送Command
Model不依赖于AWT或Swing包

Command发送者(Invoker)总是View,接收者(Receiver)总是Model
Listener的发送者(Subject)总是Model,接收者总是View(包括Audio)
Facade的调用者总是View,实现者总是Model

if else
只用作先决条件有效性检查,如: if (obj != null) ...
不用于业务逻辑,业务逻辑均使用多态处理.
