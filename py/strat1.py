class Strategy:
    val = 0
    
    def __init__(self, set_value) -> None:
       self.val = set_value

    def getter(self) -> int:
        return self.val