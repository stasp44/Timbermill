package com.datorama.oss.timbermill;


import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datorama.oss.timbermill.common.SQLJetDiskHandler;
import com.datorama.oss.timbermill.common.SqLiteDiskHandler;
import com.datorama.oss.timbermill.pipe.TimbermillServerOutputPipe;
import com.datorama.oss.timbermill.pipe.TimbermillServerOutputPipeBuilder;

import static com.datorama.oss.timbermill.common.Constants.DEFAULT_ELASTICSEARCH_URL;
import static com.datorama.oss.timbermill.common.Constants.DEFAULT_TIMBERMILL_URL;

public class TimberLogServerTest extends TimberLogTest{

    @BeforeClass
    public static void init() throws SQLException {
        String timbermillUrl = System.getenv("TIMBERMILL_URL");
        if (StringUtils.isEmpty(timbermillUrl)){
            timbermillUrl = DEFAULT_TIMBERMILL_URL;
        }
        String elasticUrl = System.getenv("ELASTICSEARCH_URL");
        if (StringUtils.isEmpty(elasticUrl)){
            elasticUrl = DEFAULT_ELASTICSEARCH_URL;
        }
        client = new ElasticsearchClient(elasticUrl, 1000, 1, null, null, null,
                7, 100, 1000000000, 3, 3,3,new SQLJetDiskHandler());
        TimbermillServerOutputPipe pipe = new TimbermillServerOutputPipeBuilder().timbermillServerUrl(timbermillUrl).maxBufferSize(200000)
                .maxSecondsBeforeBatchTimeout(3).build();
        TimberLogger.bootstrap(pipe, TEST);
    }

    @Test
    public void testSimpleTaskIndexerJob() throws InterruptedException {
       super.testSimpleTaskIndexerJob();
    }

    @Test
    public void testSwitchCasePlugin() {
        super.testSwitchCasePlugin();
    }

    @Test
    public void testSpotWithParent(){
        super.testSpotWithParent();
    }

    @Test
    public void testSimpleTasksFromDifferentThreadsIndexerJob(){
        super.testSimpleTasksFromDifferentThreadsIndexerJob();
    }

    @Test
    public void testSimpleTasksFromDifferentThreadsWithWrongParentIdIndexerJob() {
        super.testSimpleTasksFromDifferentThreadsWithWrongParentIdIndexerJob();
    }

    @Test
    public void testComplexTaskIndexerWithErrorTask() {
        super.testComplexTaskIndexerWithErrorTask();
    }

    @Test
    public void testTaskWithNullString() {
        super.testTaskWithNullString();
    }

    @Test
    public void testOverConstructor() {
        super.testOverConstructor();
    }

    @Test
    public void testOverConstructorException() {
       super.testOverConstructorException();
    }

    @Test
    public void testCorruptedInfoOnly() {
        super.testCorruptedInfoOnly();
    }

    @Test
    public void testOrphan() {
        super.testOrphan();
    }
}