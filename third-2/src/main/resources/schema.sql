-- 创建一张人脸表，包含id，name，face_url,id是主键
CREATE TABLE IF NOT EXISTS face (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    face_url VARCHAR(255)
);