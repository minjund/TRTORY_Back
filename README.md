# TRPG 시나리오 플랫폼 TRTORY

`TRTORY` 란 해당 게임의 사람들이 직접 작성한
시나리오를 공유하고 사람들의 TRPG 커뮤니티 장을 만드는 공간 입니다.

# TRTORY 개발 이유
1. TRPG 게임의 높은 진입 장벽
+ 직접 캐릭터를 생성하는데 있어 오랜 시간이 걸리고 캐릭터 생성 또한 엑셀 파일로 하기 떄문에 보기 불편한 UI로 인해 시작도 못하고 떠나는 사람들이 많습니다.
2. 시나리오 부족
+ 해외에서 번역하여 넘어오는 내용들이 대부분이며 해당 내용마저 저작권으로 인해 사용이 불가능한 내용들이 많습니다.
# TRTORY 목표
1. 무료/유료 시나리오 작성 및 공유
- 현재 뿔뿔히 흩어져 있는 사람들이 직접 쓴 시나리오를 한 곳에 모아 공유하고, 직접 시나리오를 작성하며 시나리오에 대한 테스트를 진행 할 수 있게 합니다.
2. trpg 대중화
- 직접 캐릭터를 만들어 내며 이를 엑셀파일로 저장하고 관리하는 불편함을 감소 시키고, 디스코드로 흩어져 있는 유저를 쉽게 게임에 정착 시킬 수 있도록 합니다.

### TRTORY 개발환경 ###
Trpg 시나리오 플랫폼은 JDK 17, Spring 3.x, Gradle로 개발과 테스트를 진행하였습니다.

### TRTORY 실행 방법 ###
    ./gradlew jar #jar 파일 생성

    java -jar build/libs/trpg-0.0.1-SNAPSHOT.jar #jar 파일 실행

### 테스트 실행 방법 ###
    #전체 테스트 실행
    ./gradlew test

    #시나리오 통합 테스트 실행
    ./gradlew test --tests "com.trpg.trpg_back.domain.scenario.serviceImpl.ScenariosServiceImplTest" 

    #시나리오 유닛 테스트 실행
    ./gradlew test --tests "com.trpg.trpg_back.domain.scenario.entity.ScenariosTest" 

    #유저 통합 테스트 실행
    ./gradlew test --tests "com.trpg.trpg_back.domain.user.dao.UsersRepositoryTest"

    #유저 통합 테스트 실행(레디스 사용)
    ./gradlew test --tests "com.trpg.trpg_back.domain.user.dao.redis.RedisUsersRepositoryTest"


### 테스트 케이스 구조 ###
    - 테스트 케이스는 테스트 대상의 패키지 구조를 따라갑니다.

    ScenariosServiceImplTest는 CURD와 시나리오 좋아요 API의 동시성 테스트를 진행합니다.

    ScenariosTest는 시나리오 엔티티의 유효성 및 핵심 비지니스 로직을 테스트 합니다.

    UsersRepositoryTest는 유저 CURD 검사를 진행합니다.
    
    RidisUsersRepositoryTest는 레디스를 사용한 유저 엔티티의 유효성 검사를 진행합니다.

### 테스트 결과 ##
    - 전체 테스트 실행
    > Task :test
    ....
    BUILD SUCCESSFUL in 13s
    5 actionable tasks: 1 executed, 4 up-to-date

    - 시나리오 통합 테스트 실행 결과
    > Task :test
    ....
    BUILD SUCCESSFUL in 14s
    5 actionable tasks: 1 executed, 4 up-to-date

    - 시나리오 유닛 테스트 실행 결과
    > Task :test
    BUILD SUCCESSFUL in 3s
    5 actionable tasks: 5 up-to-date

    - 유저 통합 테스트 실행 결과
    > Task :test
    ....
    BUILD SUCCESSFUL in 14s
    5 actionable tasks: 1 executed, 4 up-to-date

    #유저 통합 테스트 실행(레디스 사용)
    > Task :test
    ....
    BUILD SUCCESSFUL in 22s
    5 actionable tasks: 1 executed, 4 up-to-date
