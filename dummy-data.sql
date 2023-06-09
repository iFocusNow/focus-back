-- Parents --

INSERT INTO public.parents
(id, created_at, email, last_name_father, last_name_mother, "password", photo_url, updated_at)
VALUES('f23b7c3a-6657-4c57-a268-d78c0e1c6d1a', '2023-05-28 09:15:00', 'john@example.com', 'Smith', 'Johnson', 'password123', 'https://example.com/john.jpg', '2023-05-28 09:15:00');

INSERT INTO public.parents
(id, created_at, email, last_name_father, last_name_mother, "password", photo_url, updated_at)
VALUES('8d87427a-1024-48f7-a5ce-908d4b48f446', '2023-05-28 14:30:00', 'jane@example.com', 'Doe', 'Anderson', 'pass456', 'https://example.com/jane.jpg', '2023-05-28 14:30:00');

INSERT INTO public.parents
(id, created_at, email, last_name_father, last_name_mother, "password", photo_url, updated_at)
VALUES('c9f187ed-d1ae-437d-990d-6e07957d309f', '2023-05-28 18:45:00', 'michael@example.com', 'Brown', 'Davis', 'mysecretpass', 'https://example.com/michael.jpg', '2023-05-28 18:45:00');

INSERT INTO public.parents
(id, created_at, email, last_name_father, last_name_mother, "password", photo_url, updated_at)
VALUES('0c8ad0a7-6e7b-4eb1-90b7-1f36f07b4977', '2023-05-28 21:01:00', 'sarah@example.com', 'Johnson', 'Smith', 'abc123', 'https://example.com/sarah.jpg', '2023-05-28 21:00:00');

INSERT INTO public.parents
(id, created_at, email, last_name_father, last_name_mother, "password", photo_url, updated_at)
VALUES('77c8a3f6-1fc3-485e-b8f9-9a54f269b34d', '2023-05-28 23:30:00', 'david@example.com', 'Wilson', 'Miller', 'qwerty', 'https://example.com/david.jpg', '2023-05-28 23:30:00');

-- Children -- 

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('a8a11d01-ef85-4a76-9a87-af5d4b1f4b8c', 'C001', '2023-05-28 09:15:00', 'Emily', '2023-05-28 09:15:00', 'f23b7c3a-6657-4c57-a268-d78c0e1c6d1a');

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('74f1bca2-6a6b-4ef3-b0e4-591e9e5e8c52', 'C002', '2023-05-28 14:30:00', 'Jacob', '2023-05-28 14:30:00', '8d87427a-1024-48f7-a5ce-908d4b48f446');

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('3c71218f-0214-4a17-9b6d-0c96cc5f83a4', 'C003', '2023-05-28 18:45:00', 'Olivia', '2023-05-28 18:45:00', 'c9f187ed-d1ae-437d-990d-6e07957d309f');

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('bbd76f12-05b4-4c76-bd2f-d0191a4d5de9', 'C004', '2023-05-28 21:00:00', 'Liam', '2023-05-28 21:00:00', '0c8ad0a7-6e7b-4eb1-90b7-1f36f07b4977');

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('1f2ab978-5b76-4c20-8c92-ae4e9f6e25d7', 'C005', '2023-05-28 23:30:00', 'Ava', '2023-05-28 23:30:00', '77c8a3f6-1fc3-485e-b8f9-9a54f269b34d');

INSERT INTO public.children
(id, child_code, created_at, "name", updated_at, parent_id)
VALUES('e9b3f860-153c-42b5-9d92-1ffca36394ae', 'C006', '2023-05-29 10:45:00', 'Sophia', '2023-05-29 10:45:00', 'f23b7c3a-6657-4c57-a268-d78c0e1c6d1a');

-- Devices --

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('b073bce7-d10b-4aa7-af2a-8e81a7fb7dd1', 'Apple', 'TABLET', 'a8a11d01-ef85-4a76-9a87-af5d4b1f4b8c');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('56dbdb92-0da2-40a7-9981-0ff4e6b7d604', 'Samsung', 'PHONE', '74f1bca2-6a6b-4ef3-b0e4-591e9e5e8c52');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5', 'HP', 'LAPTOP', '3c71218f-0214-4a17-9b6d-0c96cc5f83a4');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('9e07ad33-45a7-48c2-80e0-25e839192af2', 'Dell', 'PC', 'bbd76f12-05b4-4c76-bd2f-d0191a4d5de9');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('244cd95c-8a11-4026-9e10-d9683a504a79', 'Lenovo', 'TABLET', '1f2ab978-5b76-4c20-8c92-ae4e9f6e25d7');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('21fcbda2-cac5-4d6c-b9f7-109e2eaeec34', 'Apple', 'PHONE', 'a8a11d01-ef85-4a76-9a87-af5d4b1f4b8c');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('3c434f1d-1929-4b9c-b288-65eb6697c84c', 'Microsoft', 'LAPTOP', '74f1bca2-6a6b-4ef3-b0e4-591e9e5e8c52');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('9f6d1a8e-eb70-4185-86f1-168cb3347395', 'HP', 'PC', '3c71218f-0214-4a17-9b6d-0c96cc5f83a4');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('4ebc51d3-1c14-4788-9125-9864b9397d44', 'Dell', 'TABLET', 'bbd76f12-05b4-4c76-bd2f-d0191a4d5de9');

INSERT INTO public.devices
(id, brand, "type", child_id)
VALUES('d7a8691f-8f4d-407e-b7b9-ba2821f4813c', 'Lenovo', 'PHONE', '1f2ab978-5b76-4c20-8c92-ae4e9f6e25d7');

-- Alerts --

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('a33e90e4-3829-4c17-bb0e-3456b896a6e5', '2023-05-29 08:30:00', 'BLOCK_ENTRY', '2023-05-29 08:30:00', 'a8a11d01-ef85-4a76-9a87-af5d4b1f4b8c');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('68c722f4-03ef-40e7-8db7-9b0e3e9ab08a', '2023-05-29 12:45:00', 'SOLICIT_UNBLOCK', '2023-05-29 12:45:00', '74f1bca2-6a6b-4ef3-b0e4-591e9e5e8c52');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('be0f4f97-c51b-41d5-8367-0d2f3a972f1c', '2023-05-29 15:00:00', 'PHONE_TIME_EXCEEDED', '2023-05-29 15:00:00', '3c71218f-0214-4a17-9b6d-0c96cc5f83a4');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('0de041a1-dcac-4f89-ae4c-9cc4e502e3d7', '2023-05-29 18:15:00', 'BLOCK_ENTRY', '2023-05-29 18:15:00', 'bbd76f12-05b4-4c76-bd2f-d0191a4d5de9');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('9b99eb74-7b84-4a39-89da-88096d4e8794', '2023-05-29 21:30:00', 'SOLICIT_UNBLOCK', '2023-05-29 21:30:00', '1f2ab978-5b76-4c20-8c92-ae4e9f6e25d7');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('c2083d72-0f26-4592-b4e4-8525f7a0a1e7', '2023-05-30 09:45:00', 'BLOCK_ENTRY', '2023-05-30 09:45:00', 'a8a11d01-ef85-4a76-9a87-af5d4b1f4b8c');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('f34335cc-0b9e-4d5c-98f3-73e7e0fc1289', '2023-05-30 14:00:00', 'SOLICIT_UNBLOCK', '2023-05-30 14:00:00', '74f1bca2-6a6b-4ef3-b0e4-591e9e5e8c52');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('8c3df870-76c1-4f67-9be7-0d1e141b61e5', '2023-05-30 17:15:00', 'PHONE_TIME_EXCEEDED', '2023-05-30 17:15:00', '3c71218f-0214-4a17-9b6d-0c96cc5f83a4');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('e6a4be3f-06c7-4a62-a5b5-41f9c9f86b61', '2023-05-30 20:30:00', 'BLOCK_ENTRY', '2023-05-30 20:30:00', 'bbd76f12-05b4-4c76-bd2f-d0191a4d5de9');

INSERT INTO public.alerts
(id, created_at, "type", updated_at, child_id)
VALUES('7741a7e3-6be3-4b4b-ae37-11669945fb3b', '2023-05-30 23:45:00', 'SOLICIT_UNBLOCK', '2023-05-30 23:45:00', '1f2ab978-5b76-4c20-8c92-ae4e9f6e25d7');

-- Apps --

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('bf6a10f0-7a82-4d3e-8b9a-4d1d4d04dcf3', 'https://upload.wikimedia.org/wikipedia/commons/thumb/archive/e/e7/20160929061519!Instagram_logo_2016.svg/120px-Instagram_logo_2016.svg.png', 'Instagram');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('f8a5bdc7-0bc1-4a5e-a25e-6a7de7593e7a', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/120px-Facebook_f_logo_%282019%29.svg.png', 'Facebook');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('0e46d26c-7e9b-4b32-a1a2-422b7b8efb0f', 'https://cdn3.iconfinder.com/data/icons/social-media-icons-13/512/Twitter_9-256.png', 'Twitter');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('c1283050-819c-4a15-9a8e-263ff97fbf34', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/120px-LinkedIn_logo_initials.png', 'LinkedIn');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('79bc0192-6cb3-4c6e-a55e-3f11e3f81e3e', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/120px-Google_2015_logo.svg.png', 'Google');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('1a426671-7ebe-4eaa-b4c7-981d6c83e0f3', 'https://blog.silverfernhealthcare.com/wp-content/uploads/2021/02/s-yt.png', 'Youtube');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('e5d343d4-214c-4b92-844d-04deaf07e674', 'https://descargar.org/wp-content/uploads/2017/11/reddit-android-logo.png', 'Reddit');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('4e691f40-d3c5-4e6e-8826-19257f646f4a', 'https://pngimg.com/uploads/tiktok/tiktok_PNG8.png', 'Tiktok');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('890b9b89-9f55-4a84-96c5-31d7f07b2c68', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/WhatsApp_logo-color-vertical.svg/120px-WhatsApp_logo-color-vertical.svg.png', 'WhatsApp');

INSERT INTO public.apps
(id, logo_url, "name")
VALUES('b0e69d4f-7a95-496a-b56e-ccab3f10f51b', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Netflix_2015_logo.svg/120px-Netflix_2015_logo.svg.png', 'Netflix');

-- Blockperiods --

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('6a604ded-72a4-4bb4-8b77-73250d559db0', true, true, false, false, false, false, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('0fffc8b2-40a7-4ea3-8d76-7e8e3fb9d6e2', false, false, true, true, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('e7d78384-c5e3-4b07-a5e7-61197b1de872', false, false, false, true, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('ba8a16f3-d37a-4e45-a0c5-84377bdf118e', false, false, false, true, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('35c01d5a-c29b-4e3d-a2f9-15e8e550c79f', false, false, true, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('9a942c0b-6410-4d34-9b7a-726ac474d63f', false, true, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('af92b8f7-22d7-46a6-a76f-4bb96f1b2b94', true, false, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('2f4cb173-13eb-4743-aed1-95fc9ce73d52', false, false, false, false, false, true, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('64aeaff2-9568-48a6-bd25-c8f6f7deea8d', true, true, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('cd328489-2e01-4174-99a5-8f1f44e05d4c', false, false, false, true, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('e3a93c6e-f91f-4df7-90e0-d808e77de8e2', false, false, true, true, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('f367c712-6412-4e8b-88d3-d4d8a0e4b3e4', true, false, false, false, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('70c6f704-94d1-43c6-b879-ef2ed5327b9f', false, true, true, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('62dcd6b2-9200-40f1-9647-4dc361d5861b', false, false, false, true, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('118139e3-ebd7-4f0a-9937-69fdaaf862df', true, false, false, false, false, false, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('480d3057-1f3e-471a-a2cc-d25d65c34e9a', true, true, true, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('a136cb9d-fb6f-4953-b3a4-bb9e77c3e67d', false, false, false, false, true, true, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('e27096b6-ee46-4ce5-9d97-56efce5e20b6', false, true, true, true, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('2577d836-51c6-44b7-9e2f-3ce0a0e5c9db', true, false, true, false, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('faf94c3b-72b3-4c23-976d-7ef71796b4dd', false, true, false, true, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('da2f6d6b-9e39-4e85-a9a1-5f8f58e08a15', true, false, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('3bb8d4a5-5202-4a4e-8b4a-2e6d66c9b259', false, true, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('8db61a12-d0fc-48b3-b2e6-7d41a56dd3c2', false, false, true, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('9a9b6b17-0d0b-45ff-bbf0-b0d53d617ac4', false, false, false, true, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('36f58df2-0a13-45ae-8482-3d7de7b5f53e', false, false, false, false, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('6d7be8bc-3d34-4ebd-b134-683369169d7f', false, false, false, false, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('53a17cfe-b3e4-4eaf-9303-4b320a1744a9', false, false, false, false, false, false, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('6d2c8b8f-b730-4d5e-9309-8e74373c932e', false, false, false, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('25be6b22-f5bc-47a4-9f7c-24822785a8e7', true, false, false, false, false, false, true);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('835854c1-938d-4144-8e34-09e55e5df94c', false, true, false, false, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('d22dbb3f-3656-40f3-8d06-577df383e0d2', true, false, true, false, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('f6faffd2-2983-4ddc-a20c-378d752e0064', false, true, false, true, false, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('a15302a7-c31b-4f62-a4f9-6baf9b5aef8b', false, false, true, false, true, false, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('6c9685f9-bc53-4a15-9139-8543e81e2e4f', false, false, false, true, false, true, false);

INSERT INTO public.block_periods
(id, is_friday, is_monday, is_saturday, is_sunday, is_thursday, is_tuesday, is_wednesday)
VALUES('77c89926-f8f1-4874-9f48-77d0649971b2', false, false, false, false, true, false, true);

-- Links --

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('0aee7187-2b5d-496f-85ab-5d7e4b434a9f', 'Google', 'https://www.google.com', '6a604ded-72a4-4bb4-8b77-73250d559db0', 'b073bce7-d10b-4aa7-af2a-8e81a7fb7dd1');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('849ac35c-d148-42fd-b9e3-50870f0d7b5e', 'YouTube', 'https://www.youtube.com', '0fffc8b2-40a7-4ea3-8d76-7e8e3fb9d6e2', 'b073bce7-d10b-4aa7-af2a-8e81a7fb7dd1');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('e864efc7-ae63-4da2-8f1b-5e9ee372c067', 'Facebook', 'https://www.facebook.com', 'e7d78384-c5e3-4b07-a5e7-61197b1de872', '56dbdb92-0da2-40a7-9981-0ff4e6b7d604');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('5f06d192-83a4-4b1c-b3e3-24d0e1f6782e', 'Amazon', 'https://www.amazon.com', 'ba8a16f3-d37a-4e45-a0c5-84377bdf118e', '6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('c61d6a3c-ba5b-4ebc-843a-9d9e4e5e75e3', 'Twitter', 'https://www.twitter.com', '35c01d5a-c29b-4e3d-a2f9-15e8e550c79f', '6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('be0d45a6-bfb6-4f67-827f-2ce189d58b7a', 'Instagram', 'https://www.instagram.com', '9a942c0b-6410-4d34-9b7a-726ac474d63f', '6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('59d86018-deda-422b-a8e2-640654c5c29d', 'LinkedIn', 'https://www.linkedin.com', 'af92b8f7-22d7-46a6-a76f-4bb96f1b2b94', '244cd95c-8a11-4026-9e10-d9683a504a79');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('8724d9d0-dc87-429f-ba16-c651e8e6a83b', 'Reddit', 'https://www.reddit.com', '2f4cb173-13eb-4743-aed1-95fc9ce73d52', '244cd95c-8a11-4026-9e10-d9683a504a79');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('f09d1719-8a7b-48a0-9f61-8f73c9c76a8f', 'Wikipedia', 'https://www.wikipedia.org', '64aeaff2-9568-48a6-bd25-c8f6f7deea8d', '3c434f1d-1929-4b9c-b288-65eb6697c84c');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('9b246b4a-3356-47c1-a2d2-2d13f1cb9e6e', 'Twitch', 'https://www.twitch.tv', 'cd328489-2e01-4174-99a5-8f1f44e05d4c', '3c434f1d-1929-4b9c-b288-65eb6697c84c');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('1ac1ac29-046d-40b5-a9e6-3f179d5a05e4', 'Pinterest', 'https://www.pinterest.com', 'e3a93c6e-f91f-4df7-90e0-d808e77de8e2', '9f6d1a8e-eb70-4185-86f1-168cb3347395');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('dbf9db4e-7a01-4d18-af92-1a2027ae2d84', 'GitHub', 'https://www.github.com', 'f367c712-6412-4e8b-88d3-d4d8a0e4b3e4', '9f6d1a8e-eb70-4185-86f1-168cb3347395');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('a0731c4b-b1a4-4ae7-98f7-fa98f13f641b', 'Stack Overflow', 'https://www.stackoverflow.com', '70c6f704-94d1-43c6-b879-ef2ed5327b9f', '9f6d1a8e-eb70-4185-86f1-168cb3347395');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('e9f307f4-5f6e-4745-94d2-af0c5d52d46e', 'WhatsApp', 'https://www.whatsapp.com', '62dcd6b2-9200-40f1-9647-4dc361d5861b', '4ebc51d3-1c14-4788-9125-9864b9397d44');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('e5e0b7c6-6df4-4e8d-af18-70e8eab02d18', 'Snapchat', 'https://www.snapchat.com', '118139e3-ebd7-4f0a-9937-69fdaaf862df', '4ebc51d3-1c14-4788-9125-9864b9397d44');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('285a6be1-49af-47d9-aeb5-4602b1bb1ccf', 'Spotify', 'https://www.spotify.com', '480d3057-1f3e-471a-a2cc-d25d65c34e9a', 'd7a8691f-8f4d-407e-b7b9-ba2821f4813c');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('a0a6b218-0a60-4e10-a73f-63712c233e8a', 'Netflix', 'https://www.netflix.com', 'a136cb9d-fb6f-4953-b3a4-bb9e77c3e67d', 'd7a8691f-8f4d-407e-b7b9-ba2821f4813c');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('b8f6ce77-15ff-42a7-953d-ef19e7178eb3', 'Etsy', 'https://www.etsy.com', 'e27096b6-ee46-4ce5-9d97-56efce5e20b6', '21fcbda2-cac5-4d6c-b9f7-109e2eaeec34');

INSERT INTO public.links
(id, "name", url, blockperiod_id, device_id)
VALUES('a7694b4e-981e-4e46-8547-1ea8e4e1445b', 'IMDb', 'https://www.imdb.com', '2577d836-51c6-44b7-9e2f-3ce0a0e5c9db', '21fcbda2-cac5-4d6c-b9f7-109e2eaeec34');

-- AppDevices -- 

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('4dc6076c-8d9c-4d80-86f5-8fb77281a3cc', 'bf6a10f0-7a82-4d3e-8b9a-4d1d4d04dcf3', '6a604ded-72a4-4bb4-8b77-73250d559db0', '56dbdb92-0da2-40a7-9981-0ff4e6b7d604');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('b9cc8bbf-1e6d-4ce4-97c3-18f9fb4c1fe2', 'bf6a10f0-7a82-4d3e-8b9a-4d1d4d04dcf3', '0fffc8b2-40a7-4ea3-8d76-7e8e3fb9d6e2', '6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('3ffae24e-f3b7-482f-8de2-49e3c51e5f95', 'f8a5bdc7-0bc1-4a5e-a25e-6a7de7593e7a', 'e7d78384-c5e3-4b07-a5e7-61197b1de872', '9e07ad33-45a7-48c2-80e0-25e839192af2');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('fc0e0b8b-2e39-4418-9c3f-6aaf85db0d35', 'f8a5bdc7-0bc1-4a5e-a25e-6a7de7593e7a', 'ba8a16f3-d37a-4e45-a0c5-84377bdf118e', '244cd95c-8a11-4026-9e10-d9683a504a79');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('e1d2f52c-2393-4b63-9a41-86fb0f1d8a1c', '0e46d26c-7e9b-4b32-a1a2-422b7b8efb0f', '35c01d5a-c29b-4e3d-a2f9-15e8e550c79f', '244cd95c-8a11-4026-9e10-d9683a504a79');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('20f8822b-1cb5-4e66-8d0d-bc614f5f18dd', '0e46d26c-7e9b-4b32-a1a2-422b7b8efb0f', '9a942c0b-6410-4d34-9b7a-726ac474d63f', '21fcbda2-cac5-4d6c-b9f7-109e2eaeec34');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('f283ade9-3f50-439a-98ff-bfde3c3e0c46', '0e46d26c-7e9b-4b32-a1a2-422b7b8efb0f', 'af92b8f7-22d7-46a6-a76f-4bb96f1b2b94', '3c434f1d-1929-4b9c-b288-65eb6697c84c');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('e88ae2fe-2608-448c-8b7f-eeea5a01853d', 'c1283050-819c-4a15-9a8e-263ff97fbf34', '2f4cb173-13eb-4743-aed1-95fc9ce73d52', '9f6d1a8e-eb70-4185-86f1-168cb3347395');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('7c4edfae-4b63-4e69-a1f1-32c6d343d5ab', 'c1283050-819c-4a15-9a8e-263ff97fbf34', '64aeaff2-9568-48a6-bd25-c8f6f7deea8d', '4ebc51d3-1c14-4788-9125-9864b9397d44');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('b8b7d43d-6e69-4f55-8816-bb057f4f33c1', 'c1283050-819c-4a15-9a8e-263ff97fbf34', 'cd328489-2e01-4174-99a5-8f1f44e05d4c', 'd7a8691f-8f4d-407e-b7b9-ba2821f4813c');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('8bcf7dcf-7d18-4b1f-b7f9-5bdf6f06f9de', '79bc0192-6cb3-4c6e-a55e-3f11e3f81e3e', 'e3a93c6e-f91f-4df7-90e0-d808e77de8e2', 'd7a8691f-8f4d-407e-b7b9-ba2821f4813c');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('9fd59428-4f2b-43c1-b0c0-45f2672b0eae', '79bc0192-6cb3-4c6e-a55e-3f11e3f81e3e', 'f367c712-6412-4e8b-88d3-d4d8a0e4b3e4', '4ebc51d3-1c14-4788-9125-9864b9397d44');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('71a4c5ff-3ed9-48af-936f-eb37fa92462a', '79bc0192-6cb3-4c6e-a55e-3f11e3f81e3e', '70c6f704-94d1-43c6-b879-ef2ed5327b9f', '9f6d1a8e-eb70-4185-86f1-168cb3347395');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('62eb6d46-cf7c-4db3-9c39-6b286fbfe527', '1a426671-7ebe-4eaa-b4c7-981d6c83e0f3', '62dcd6b2-9200-40f1-9647-4dc361d5861b', '3c434f1d-1929-4b9c-b288-65eb6697c84c');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('00e8ad5f-3d33-4bfa-8450-5da238f5fcf6', '1a426671-7ebe-4eaa-b4c7-981d6c83e0f3', '118139e3-ebd7-4f0a-9937-69fdaaf862df', '21fcbda2-cac5-4d6c-b9f7-109e2eaeec34');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('9ae8ed2d-8f82-406a-8160-7a702476ad7b', '1a426671-7ebe-4eaa-b4c7-981d6c83e0f3', '480d3057-1f3e-471a-a2cc-d25d65c34e9a', '244cd95c-8a11-4026-9e10-d9683a504a79');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('be1b34ef-94fb-4d5b-8236-1d9262bfe17d', 'e5d343d4-214c-4b92-844d-04deaf07e674', 'a136cb9d-fb6f-4953-b3a4-bb9e77c3e67d', '9e07ad33-45a7-48c2-80e0-25e839192af2');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('3a7867ce-685e-4c68-9de3-35e6e0f2f8da', 'e5d343d4-214c-4b92-844d-04deaf07e674', 'e27096b6-ee46-4ce5-9d97-56efce5e20b6', '6d3b5e5d-0ef3-43e4-b87a-2e3a4609f5b5');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('5df8a3b5-8ebe-4d22-a0e2-7ef396d57ff4', 'e5d343d4-214c-4b92-844d-04deaf07e674', '2577d836-51c6-44b7-9e2f-3ce0a0e5c9db', '56dbdb92-0da2-40a7-9981-0ff4e6b7d604');

INSERT INTO public.app_devices
(id, app_id, blockperiod_id, device_id)
VALUES('3e0732a4-dc76-4318-b1fc-2e37d3a2be70', '4e691f40-d3c5-4e6e-8826-19257f646f4a', 'faf94c3b-72b3-4c23-976d-7ef71796b4dd', 'b073bce7-d10b-4aa7-af2a-8e81a7fb7dd1');
