using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Geometric;

namespace GeometricTest
{
    [TestClass]
    public class CircleTest
    {
        public TestContext TestContext { get; set; }

        private double delta = 0.1;

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Radius less than zero")]
        public void CircleRadiusLessThanZeroTest()
        {
            Circle circle = new Circle(-14.5d);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Radius less than zero")]
        public void CircleRadiusEqualsZeroTest()
        {
            Circle circle = new Circle(0);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void CircleRadiusGreaterThanZeroCountCircuitTest()
        {
            Circle circle = new Circle(Double.Parse(TestContext.DataRow["CircleR"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["CircleCircuit"].ToString());
            Assert.AreEqual(expected, circle.countCircuit(), delta);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void CircleRadiusGreaterThanZeroCountSurfaceTest()
        {
            Circle circle = new Circle(Double.Parse(TestContext.DataRow["CircleR"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["CircleSurface"].ToString());
            Assert.AreEqual(expected, circle.countSurface(), delta);
        }

        [TestMethod]
        public void CircleToStringTest()
        {
            Circle circle = new Circle(4);
            StringAssert.Equals("Circle with r = 4", circle.ToString());
        }
    }
}
