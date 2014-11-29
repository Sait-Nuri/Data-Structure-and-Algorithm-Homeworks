/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author said
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({hw04.VariableTest.class, hw04.AbsTest.class, hw04.CosTest.class, hw04.SinTest.class, hw04.GITCompilerTest.class, hw04.OperandTest.class, hw04.TanTest.class, hw04.MyDoubleTest.class, hw04.CompilableTest.class, hw04.LogTest.class, hw04.ExecutableTest.class, hw04.HW04Test.class, hw04.ExpTest.class, hw04.InputTest.class, hw04.VarTest.class, hw04.PrintTest.class, hw04.MathFuncTest.class, hw04.SqrtTest.class})
public class Hw04Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
