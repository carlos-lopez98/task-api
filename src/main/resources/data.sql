-- Seed users
INSERT INTO app_user (id, name, email, created_at) VALUES
(1, 'Alex Grape', 'carlos@example.com', NOW()),
(2, 'Jane Doe', 'jane@example.com', NOW()),
(3, 'John Smith', 'john@example.com', NOW());

-- Seed tasks
INSERT INTO task (id, title, description, created_at, user_id) VALUES
(1, 'Build task tracker', 'Set up initial backend structure', NOW(), 1),
(2, 'Review JPA', 'Reinforce entity and relationship concepts', NOW(), 1),
(3, 'Refactor services', 'Split logic into layers', NOW(), 2),
(4, 'Add DTO layer', 'Improve API cleanliness', NOW(), 3);