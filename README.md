# play-clean-ddd

Clean Architecture ベースのモジュール化した実装サンプル。

## テスト用データベース

docker で準備しています。

```shell
cd docker 
docker-compose up -d postgres
```

## 実行

```shell
sbt web/run
```