-- 创建一张第三方处理记录表,we_data存储我方数据，third_data存储三方数据,rtype存储业务类型,ADD、DELETE、UPDATE、SELECT,third三方系统唯一标识
CREATE TABLE IF NOT EXISTS third_history (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    we_data VARCHAR(255),
    third_data VARCHAR(255),
    rtype VARCHAR(255),
    third VARCHAR(255)
);

-- 创建一张人脸表，包含id，name，face_url,id是主键
CREATE TABLE IF NOT EXISTS face (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    face_url VARCHAR(255)
);