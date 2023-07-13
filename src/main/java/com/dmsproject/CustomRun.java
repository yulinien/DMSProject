package com.dmsproject;

import com.dmsproject.controller.pojo.MigrationDTO;
import com.dmsproject.controller.service.MigrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomRun implements CommandLineRunner {


    private static Logger logger = LoggerFactory.getLogger(DmsProjectApplication.class);

    private final MigrationService migrationService;

    private final ConfigurableApplicationContext context;

    public CustomRun(MigrationService migrationService, ConfigurableApplicationContext context) {
        this.migrationService = migrationService;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {

        if ( args.length > 0 && args[0].equals("migrate")) {

            MigrationDTO migrationDTO = migrationService.timeSheetMigration();

            if (migrationDTO.getStatus() == 1) {
                logger.info("migration成功，即將關閉");
                context.close();
                System.exit(0);
            } else {
                logger.info("migration失敗，請檢查SERVICE，執行後關閉");
                context.close();
                System.exit(0);
            }
        }else {
            logger.info("缺少migrate參數，請重新執行並使用正確命令");
        }
    }
}
