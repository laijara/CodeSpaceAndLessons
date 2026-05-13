#!/bin/bash

# Завершать скрипт при любой ошибке
set -e

echo "=== 1. Обновление системы ==="
sudo apt update && sudo apt upgrade -y

echo "=== 2. Установка X-сервера, LXQt и дисплейного менеджера ==="
# Установка строго без лишних рекомендованных пакетов
sudo apt install --no-install-recommends xorg lxqt-core openbox sddm -y

echo "=== 3. Установка и настройка xrdp ==="
sudo apt install xrdp -y

# Разрешаем запуск X-сервера для всех пользователей (исправляет черный экран)
sudo sed -i 's/allowed_users=console/allowed_users=anybody/g' /etc/X11/Xwrapper.config || \
echo "allowed_users=anybody" | sudo tee -a /etc/X11/Xwrapper.config

echo "=== 4. Настройка XRDP-сессии под LXQt ==="
# Настройка глобального запуска LXQt для xrdp-сессий
sudo tee /etc/xrdp/startwm.sh > /dev/null << 'EOF'
#!/bin/sh
if [ -r /etc/profile ]; then
    . /etc/profile
fi
if [ -r ~/.profile ]; then
    . ~/.profile
fi
test -x /etc/X11/Xsession && exec /etc/X11/Xsession
exec startlxqt
EOF

# Добавляем LXQt в конфиг текущего пользователя на всякий случай
mkdir -p ~/.xsession
echo "exec startlxqt" > ~/.xsession
chmod +x ~/.xsession

echo "=== 5. Перезапуск и включение служб ==="
sudo systemctl enable sddm
sudo systemctl enable xrdp
sudo systemctl restart xrdp

echo "=== Установка завершена! ==="
echo "IP-адрес вашего Raspberry Pi для подключения через RDP:"
hostname -I | awk '{print $1}'
