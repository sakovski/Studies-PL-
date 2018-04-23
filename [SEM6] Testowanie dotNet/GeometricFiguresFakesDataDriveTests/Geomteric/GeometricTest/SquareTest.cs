using System;
using Geometric;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace GeometricTest
{
    [TestClass]
    public class SquareTest
    {
        public TestContext TestContext { get; set; }
        private double delta = 0.1;

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void SquareALessThanZeroTest()
        {
            Square square = new Square(-4.56);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void SquareAZeroTest()
        {
            Square square = new Square(0);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void SquareCircuitTest()
        {
            Square square = new Square(Double.Parse(TestContext.DataRow["SquareA"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["SquareCircuit"].ToString());
            Assert.AreEqual(expected, square.countCircuit(), delta);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void SquareSurfaceTest()
        {
            Square square = new Square(Double.Parse(TestContext.DataRow["SquareA"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["SquareSurface"].ToString());
            Assert.AreEqual(expected, square.countSurface(), delta);
        }

        public void SquareToStringTest()
        {
            Square square = new Square(4.5);
            StringAssert.Equals("Square with a = 4.5", square.ToString());
        }
    }
}
