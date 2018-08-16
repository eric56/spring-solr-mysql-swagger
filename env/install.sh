/usr/local/bin/docker-compose up -d
sudo docker exec -it koin-solr bin/solr create_core -c financial-solr-core
sudo docker cp solr/db-data-config.xml koin-solr:/opt/solr/server/solr/financial-solr-core/conf
sudo docker cp solr/managed-schema koin-solr:/opt/solr/server/solr/financial-solr-core/conf
sudo docker cp lib/mysql-connector-java-5.1.46.jar koin-solr:/opt/solr/contrib/dataimporthandler-extras/lib