 shellcheck disable=SC2164
for dir in */
do (
  cd "$dir" || exit
  mvn clean install
)
done
docker stop soa-service
docker stop genocide-service
docker stop main-db
docker rm soa-service
docker rm genocide-service
#docker rm main-db
docker rmi soa-genocide-service --force
docker rmi soa-soa-service --force
#docker network rm backend
docker-compose up