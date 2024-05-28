


# tutorial
>- https://www.youtube.com/watch?v=OzQr9Cx46q0
>- https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html
>- https://filezilla-project.org/download.php?type=client#close

# instalar jdk
>- https://openjdk.org/install/
>- sudo apt-get install openjdk-8-jdk
>- sudo apt install nginx
>- sudo nano /etc/nginx/sites-available/app

# configuración
<p>
server {
    listen 80;
    server_name 3.17.172.184;
    location / {
        proxy_pass http://localhost:8080; # Puerto en el que se ejecuta tu aplicación Spring Boot
        proxy_set_header Host $Host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
</p>

# iniciar todo
>- sudo ln -s /etc/nginx/sites-available/app /etc/nginx/sites-enabled/
>- sudo service nginx restart

#
>- sudo nano /etc/systemd/system/app.service
<p>
[Unit]
Description=Spring Boot App
After=syslog.target

[Service]
User=ubuntu
ExecStart=java -jar -Dspring.profiles.active=amazonmysql -Dserver.port=8080 /home/ubuntu/app/app.jar
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
</p>
>- sudo systemctl enable app.service
>- sudo reboot now #esperar varios minutos
>- sudo journalctl -u app.service -xe #cada que se actualice el jar
