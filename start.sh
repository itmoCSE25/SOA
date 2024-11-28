# shellcheck disable=SC2164
for dir in */
do (
  cd "$dir" || exit
  mvn clean install
)
done
docker stop soa_service
docker stop genocide_service
docker stop main-db
docker rm soa_service
docker rm main-db
docker rm genocide_service
docker network rm backend
docker-compose up