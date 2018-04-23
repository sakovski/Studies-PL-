using System;
using Geometric;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace GeometricTest
{
    [TestClass]
    public class TriangleTest
    {
        public TestContext TestContext { get; set; }
        private double delta = 0.1;

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleALessThanZeroTest()
        {
            Triangle triangle = new Triangle(-1.3, 4.3, 5.2);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleBLessThanZeroTest()
        {
            Triangle triangle = new Triangle(1.3, -4, 5);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleCLessThanZeroTest()
        {
            Triangle triangle = new Triangle(-1.3, 4, -5);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleAEqualsZeroTest()
        {
            Triangle triangle = new Triangle(0, 4, -5);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleBEqualsZeroTest()
        {
            Triangle triangle = new Triangle(-1.3, 0, -5);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides length less than zero")]
        public void TriangleCEqualsZeroTest()
        {
            Triangle triangle = new Triangle(-1.3, 4, 0);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sum of two sides length cant be less than third side length")]
        public void TriangleAGreatherThanSumBCTest()
        {
            Triangle triangle = new Triangle(10, 4, 1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sum of two sides length cant be less than third side length")]
        public void TriangleBGreatherThanSumACTest()
        {
            Triangle triangle = new Triangle(4, 10, 1);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sum of two sides length cant be less than third side length")]
        public void TriangleCGreatherThanSumABTest()
        {
            Triangle triangle = new Triangle(1, 4, 10);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void TriangleCircuitTest()
        {
            Triangle triangle = new Triangle(Double.Parse(TestContext.DataRow["TriangleA"].ToString()), Double.Parse(TestContext.DataRow["TriangleB"].ToString()), Double.Parse(TestContext.DataRow["TriangleC"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["TriangleCircuit"].ToString());
            Assert.AreEqual(expected, triangle.countCircuit(), delta);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void TriangleSurfaceTest()
        {
            Triangle triangle = new Triangle(Double.Parse(TestContext.DataRow["TriangleA"].ToString()), Double.Parse(TestContext.DataRow["TriangleB"].ToString()), Double.Parse(TestContext.DataRow["TriangleC"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["TriangleSurface"].ToString());
            Assert.AreEqual(expected, triangle.countSurface(), delta);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void TriangleIsRightALowerTest()
        {
            Triangle triangle = new Triangle(6, 8, 10);
            Assert.IsTrue(triangle.isRight());
        }

        [TestMethod]
        public void TriangleIsRightBLowerTest()
        {
            Triangle triangle = new Triangle(12, 9, 15);
            Assert.IsTrue(triangle.isRight());
        }

        [TestMethod]
        public void TriangleIsRightCLowerTest()
        {
            Triangle triangle = new Triangle(5, 4, 3);
            Assert.IsTrue(triangle.isRight());
        }

        [TestMethod]
        public void TriangleIsEquilateralTrueTest()
        {
            Triangle triangle = new Triangle(6.2, 6.2, 6.2);
            Assert.IsTrue(triangle.isEquilateral());
        }

        [TestMethod]
        public void TriangleIsEquilateralFalseTest()
        {
            Triangle triangle = new Triangle(6.2, 6.2, 10.456789);
            Assert.IsFalse(triangle.isEquilateral());
        }

        [TestMethod]
        public void TriangleIsIsosceleslACTest()
        {
            Triangle triangle = new Triangle(6.2, 10.456789, 6.2);
            Assert.IsTrue(triangle.isIsosceles());
        }

        [TestMethod]
        public void TriangleIsIsoscelesBCTest()
        {
            Triangle triangle = new Triangle(10.456789, 6.2, 6.2);
            Assert.IsTrue(triangle.isIsosceles());
        }

        [TestMethod]
        public void TriangleIsIsoscelesFalseTest()
        {
            Triangle triangle = new Triangle(10.456789, 6.2, 6.5);
            Assert.IsFalse(triangle.isIsosceles());
        }

        [TestMethod]
        public void TriangleToStringTest()
        {
            Triangle triangle = new Triangle(10, 6, 6);
            StringAssert.Equals("Triangle with a = 10; b = 6; c = 6", triangle.ToString());
        }
    }
}
