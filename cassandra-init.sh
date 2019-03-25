CQL="CREATE KEYSPACE IF NOT EXISTS webfluxapi WITH replication = {'class':'SimpleStrategy','replication_factor':'1'};
USE webfluxapi;
CREATE TABLE IF NOT EXISTS planet(id text, name text, climate text, terrain text, movie_appearances int, PRIMARY KEY(id));"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

exec /docker-entrypoint.sh "$@"
