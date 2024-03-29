mvn clean package
docker build -t naprawagsm .
docker stop naprawagsm || true
docker rm naprawagsm || true
docker run -d -p 8080:8080 --name=naprawagsm -e SPRING_PROFILES_ACTIVE=prod --network naprawagsm-network --restart unless-stopped naprawagsm
