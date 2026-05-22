-- 插入初始测试数据
INSERT INTO books (title, author, isbn, publisher, publish_year, description, price, created_at, updated_at)
VALUES
('深入理解Java虚拟机', '周志明', '978-7-111-12345-6', '机械工业出版社', 2019,
 '全面解析JVM原理与调优实践，涵盖内存模型、垃圾回收、类加载等核心内容。', 89.00, NOW(), NOW()),

('Spring实战 第6版', '克雷格·沃斯', '978-7-115-54321-0', '人民邮电出版社', 2022,
 'Spring框架权威指南，从基础到微服务、响应式编程全覆盖。', 99.00, NOW(), NOW()),

('Java核心技术 卷I', '凯·S·霍斯特曼', '978-7-111-11223-4', '机械工业出版社', 2020,
 'Java入门经典教材，系统讲解Java语法、面向对象、集合和泛型。', 129.00, NOW(), NOW()),

('算法导论 第四版', '托马斯·科尔曼', '978-7-111-11111-1', '机械工业出版社', 2021,
 '计算机算法领域的圣经，深入讲解算法设计与分析。', 168.00, NOW(), NOW()),

('RESTful Web APIs', 'Leonard Richardson', '978-1-449-35806-8', 'O''Reilly Media', 2013,
 'REST API设计最佳实践，教你构建优雅的Web服务。', 78.00, NOW(), NOW());
