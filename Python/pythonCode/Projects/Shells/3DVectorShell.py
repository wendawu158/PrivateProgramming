class Vector3D:
    def __init__(self, x_position, y_position, z_position):
        self.x_position = x_position
        self.y_position = y_position
        self.z_position = z_position

    def __add__(self, other):
        self.x_position += other.x_position
        self.y_position += other.y_position
        self.z_position += other.z_position

    def __sub__(self, other):
        self.x_position -= other.x_position
        self.y_position -= other.y_position
        self.z_position -= other.x_position

    def __dir__(self):
        return self.x_position, self.y_position, self.z_position


point_x = Vector3D(1, 1, 1)
print(dir(point_x))
