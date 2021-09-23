# play-clean-ddd

Clean Architecture ベースのPlayFramework モノリス。依存方向をbuild.sbtで制御している。

## 依存関係

![architecture](architecture.drawio)

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